package org.apache.lens.ml.spark.forecast;

import org.apache.lens.api.LensException;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.rdd.RDD;

import java.util.Map;

/**
 * Created by deepak on 10/16/14.
 */
public class WeightedMovingAverageTrainer extends BaseForecastTrainer {

    private double[] weights;

    public WeightedMovingAverageTrainer(String name, String description) {
        super(name, description);
    }

    @Override
    public void parseTrainerParams(Map<String, String> params) {
        String str = getParamValue("weights", "1");
        String[] tokens = str.split(",");
        weights = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++)
            weights[i] = Double.parseDouble(tokens[i]);
    }

    @Override
    protected BaseSparkForecastModel trainInternal(String modelId, RDD<LabeledPoint> trainingRDD) throws LensException {
        WeightedMovingAverageModel model = WeightedMovingAverageModel.createModel(trainingRDD, timeVariable, weights);
        return new BaseSparkForecastModel<WeightedMovingAverageModel>(modelId, model);
    }
}
