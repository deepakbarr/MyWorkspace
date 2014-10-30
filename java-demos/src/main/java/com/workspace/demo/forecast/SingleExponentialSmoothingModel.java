package org.apache.lens.ml.spark.forecast;

import org.apache.lens.ml.spark.forecast.AbstractForecastModel;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.rdd.RDD;

import java.util.*;

/**
 * Created by deepak on 10/14/14.
 */

//ToDO How to throw grill exceptions
public class SingleExponentialSmoothingModel extends AbstractForecastModel {

    private double alpha;

    /**
     * @param alpha
     * @param timeVariable
     */
    public SingleExponentialSmoothingModel(double alpha, int timeVariable) {
        if (alpha < 0.0 || alpha > 1.0)
            throw new IllegalArgumentException("SingleExponentialSmoothingModel: Invalid smoothing constant, should be between 0 and 1]");
        this.alpha = alpha;
        this.timeVariable = timeVariable;
    }

    /**
     * @param trainingRDD
     */
    private void init(RDD<LabeledPoint> trainingRDD) {
        this.observationsMap = createTimeSeriesMap(trainingRDD);
        computeFit();
        calculateAccuracyMetrics();
        this.initialized = true;
    }

    /**
     *
     */
    private void computeFit() {
        Iterator<Long> iterator = observationsMap.keySet().iterator();
        minTimeStamp = iterator.next();

        long lastTimeStamp, currentTimeStamp = iterator.next();
        double forecastValue;
        forecastMap = new TreeMap();

        while (iterator.hasNext()) {
            lastTimeStamp = currentTimeStamp;
            currentTimeStamp = iterator.next();
            forecastValue = getForecast(lastTimeStamp);
            forecastMap.put(currentTimeStamp, forecastValue);
            if (currentTimeStamp > maxTimeStamp)
                maxTimeStamp = currentTimeStamp;
        }
    }

    /**
     * @param trainingRDD
     * @param timeVariable
     * @param smoothingCoefficient
     * @param stepSize
     * @return
     */
    public static SingleExponentialSmoothingModel train(RDD<LabeledPoint> trainingRDD, int timeVariable, double smoothingCoefficient, double stepSize) {

        if (smoothingCoefficient != -1) {
            SingleExponentialSmoothingModel model = new SingleExponentialSmoothingModel(smoothingCoefficient, timeVariable);
            model.init(trainingRDD);
            return model;
        }

        SingleExponentialSmoothingModel bestModel = null;
        SingleExponentialSmoothingModel model;

        double minMSE = Double.MAX_VALUE;

        for (double smoothingConstant = 0; smoothingConstant <= 1.0d; smoothingConstant += stepSize) {

            model = new SingleExponentialSmoothingModel(smoothingConstant, timeVariable);
            model.init(trainingRDD);

            if (model.getMSE() < minMSE) {
                bestModel = model;
                minMSE = bestModel.getMSE();
            }
        }
        return bestModel;
    }

    /**
     * @param timeStamp
     * @return
     */
    protected double getForecast(long timeStamp) {
        double forecast = alpha * getObservedValue(timeStamp)
                + (1.0 - alpha) * getForecastValue(timeStamp);
        return forecast;
    }

    /**
     * @param timeStamp
     * @return
     * @throws IllegalArgumentException
     */
    protected double getForecastValue(long timeStamp) throws IllegalArgumentException {
        Double value = forecastMap.get(timeStamp);
        if (value != null)
            return value;

        try {
            double firstValue = getObservedValue(minTimeStamp);
            forecastMap.put(timeStamp, firstValue);
            return value;

        } catch (Exception e) {
            throw new IllegalArgumentException("No observation/forecast value found for time value = [" + timeStamp + "]");
        }
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
    public double getMSE() {
        return accuracyIndicators.getMse();
    }

    /**
     * @return
     */
    protected int getNumberOfPeriods() {
        return 1;
    }

    /**
     * @param timeStamps
     * @return
     */
    public Map<Long, Double> predict(long[] timeStamps) {
        double forecastValue;
        Map<Long, Double> predictions = new HashMap<Long, Double>();
        try {
            if (initialized) {
                for (Long ts : timeStamps) {
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
