package org.apache.lens.ml.spark.forecast;

import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.rdd.RDD;

import java.util.*;

/**
 * Created by deepak on 10/16/14.
 */
public class MovingAverageModel extends AbstractForecastModel {

    private double[] weights;

    /**
     * @param period
     * @param timeVariable
     */
    protected MovingAverageModel(int period, int timeVariable) {
        double[] weights = new double[period];
        for (int p = 0; p < period; p++)
            weights[p] = 1.0 / period;
        setWeights(weights);
        this.timeVariable = timeVariable;
    }

    protected void setWeights(double[] weights) {
        this.weights = weights;
    }

    /**
     * @param trainingRDD
     */
    private void init(RDD<LabeledPoint> trainingRDD) {
        this.observationsMap = createTimeSeriesMap(trainingRDD);
        Iterator<Long> it = observationsMap.keySet().iterator();
        minTimeStamp = it.next();
        timeDiff = it.next() - minTimeStamp;
        computeFit();
        calculateAccuracyMetrics();
        this.initialized = true;
    }

    /**
     *
     */
    private void computeFit() {

        Iterator<Long> iterator = observationsMap.keySet().iterator();
        double forecastValue;
        long currentTimeStamp, lastTimeStamp;
        forecastMap = new TreeMap();

        do {
            currentTimeStamp = iterator.next();
        } while (currentTimeStamp < (getNumberOfPeriods() - 1) * timeDiff && iterator.hasNext());

        while (iterator.hasNext()) {
            lastTimeStamp = currentTimeStamp;
            currentTimeStamp = iterator.next();
            forecastValue = getForecast(lastTimeStamp);
            forecastMap.put(currentTimeStamp, forecastValue);
        }
    }

    /**
     * @param timeStamp
     * @return
     */
    protected double getForecast(long timeStamp)
            throws IllegalArgumentException {
        int periods = getNumberOfPeriods();
        long t = timeStamp;
        if (timeStamp - timeDiff * periods < minTimeStamp)
            return getObservedValue(t);
        double forecast = 0.0;
        for (int p = periods - 1; p >= 0; p--) {
            t -= timeDiff;
            forecast += weights[p] * getObservedValue(t);
        }
        return forecast;
    }

    /**
     * @param trainingRDD
     * @param timeVariable
     * @param period
     * @return
     */
    public static MovingAverageModel createModel(RDD<LabeledPoint> trainingRDD, int timeVariable, int period) {
        MovingAverageModel model = new MovingAverageModel(period, timeVariable);
        model.init(trainingRDD);
        return model;
    }

    /**
     * @param timeStamp
     * @return
     * @throws IllegalArgumentException
     */
    protected double getObservedValue(double timeStamp) throws IllegalArgumentException {
        Double value = observationsMap.get(timeStamp);
        if (value != null)
            return value;
        throw new IllegalArgumentException("No observation found for time value = [" + timeStamp + "]");
    }

    /**
     * @return
     */
    protected int getNumberOfPeriods() {
        return weights.length;
    }


    /**
     * @param timeStamps
     * @return
     */
    @Override
    public Map<Long, Double> predict(long[] timeStamps) {
        double forecastValue;
        Map<Long, Double> predictions = new HashMap<Long, Double>();
        try {
            if (initialized) {
                for (long ts : timeStamps) {
                    if (ts > maxTimeStamp)
                        forecastValue = getForecast(maxTimeStamp);
                    else forecastValue = getForecast(ts);
                    predictions.put(ts, forecastValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return predictions;
    }
}