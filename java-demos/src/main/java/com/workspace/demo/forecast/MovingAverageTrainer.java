package org.apache.lens.ml.spark.forecast;

import org.apache.lens.api.LensException;
import org.apache.lens.ml.Algorithm;
import org.apache.lens.ml.TrainerParam;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.rdd.RDD;

import java.util.Map;

/**
 * Created by deepak on 10/16/14.
 */

@Algorithm(
        name = "spark_moving_average",
        description = "Spark moving average trainer"
)
public class MovingAverageTrainer extends BaseForecastTrainer {

    @TrainerParam(name = "stepSize", help = "Max number of iterations", defaultValue = "1")
    private int period;

    public MovingAverageTrainer(String name, String description) {
        super(name, description);
    }

    @Override
    public void parseTrainerParams(Map<String, String> params) {
        period = getParamValue("period", 1);
    }

    @Override
    protected BaseSparkForecastModel trainInternal(String modelId, RDD<LabeledPoint> trainingRDD) throws LensException {
        MovingAverageModel model = MovingAverageModel.createModel(trainingRDD, timeVariable, period);
        return new BaseSparkForecastModel<MovingAverageModel>(modelId, model);
    }
}
