package org.apache.lens.ml.spark.forecast;

import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.rdd.RDD;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by deepak on 10/16/14.
 */
public abstract class AbstractForecastModel {

    protected boolean initialized;
    protected SortedMap<Long, Double> observationsMap;
    protected AccuracyIndicators accuracyIndicators = new AccuracyIndicators();
    protected SortedMap<Long, Double> forecastMap;
    protected int timeVariable;
    protected long maxTimeStamp;
    protected long minTimeStamp;
    protected long timeDiff;
    protected double TOLERANCE = 0.0000005;

    public abstract Map<Long, Double> predict(long[] timeStamps);


    /**
     * @param trainingRDD
     * @return
     */
    protected SortedMap<Long, Double> createTimeSeriesMap(RDD<LabeledPoint> trainingRDD) {

        LabeledPoint lp;
        long timeStamp;
        double dependentVariable;
        SortedMap<Long, Double> trainingDataMap = new TreeMap();

        scala.collection.Iterator<LabeledPoint> iterator = trainingRDD.toLocalIterator();

        while (iterator.hasNext()) {
            lp = iterator.next();
            timeStamp = (long) lp.features().apply(timeVariable);
            dependentVariable = lp.label();
            observationsMap.put(timeStamp, dependentVariable);
        }
        return trainingDataMap;
    }


    public void calculateAccuracyMetrics() {

        // Reset various helper summations
        double sumErr = 0.0;
        double sumAbsErr = 0.0;
        double sumAbsPercentErr = 0.0;
        double sumErrSquared = 0.0;

        // Calculate the Sum of the Absolute Errors
        Iterator<Long> it = forecastMap.keySet().iterator();
        long timeStamp;

        while (it.hasNext()) {

            timeStamp = it.next();
            double observedValue = observationsMap.get(timeStamp);
            double forecastValue = forecastMap.get(timeStamp);

            // Calculate error in forecast, and update sums appropriately
            double error = observedValue - forecastValue;
            sumErr += error;
            sumAbsErr += Math.abs(error);
            sumAbsPercentErr += Math.abs(error / observedValue);
            sumErrSquared += error * error;
        }

        // Initialize the accuracy indicators
        int n = forecastMap.size();
        accuracyIndicators.setBias(sumErr / n);
        accuracyIndicators.setMad(sumAbsErr / n);
        accuracyIndicators.setMape(sumAbsPercentErr / n);
        accuracyIndicators.setMse(sumErrSquared / n);
        accuracyIndicators.setSae(sumAbsErr);
    }
}

