package org.apache.lens.ml.spark.forecast;

import org.apache.lens.ml.LabelledPrediction;
import org.apache.lens.ml.MultiPrediction;
import org.apache.spark.mllib.classification.ClassificationModel;
import org.apache.spark.mllib.linalg.Vectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by deepak on 10/14/14.
 */
public class BaseSparkForecastModel<MODEL extends AbstractForecastModel> extends ForecastingModel {

    private final String modelId;
    private final MODEL forecastModel;

    public BaseSparkForecastModel(String modelId, MODEL model) {
        this.modelId = modelId;
        this.forecastModel = model;
    }

    public MultiPrediction predict(Object... args) {
        Map<Long, Double> forecastMap = forecastModel.predict(getTimeStamps(args));
        int numberOfPredictions = forecastMap.size();
        List<LabelledPrediction> labelledPredictions = new ArrayList<LabelledPrediction>(numberOfPredictions);

        for (Long timeStamp : forecastMap.keySet())
            labelledPredictions.add(new ForecastingModel.ForecastingLabel(timeStamp, forecastMap.get(timeStamp)));

        return new ForecastingPredictions(labelledPredictions);
    }

    public String getId() {
        return modelId;
    }

    public final long[] getTimeStamps(Object[] args) {
        long[] features = new long[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Long) {
                features[i] = (Long) args[i];
            } else if (args[i] instanceof String) {
                features[i] = Long.parseLong((String) args[i]);
            } else {
                features[i] = 0;
            }
        }
        return features;
    }
}
