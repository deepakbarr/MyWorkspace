package org.apache.lens.ml.spark.forecast;

import org.apache.lens.api.LensException;
import org.apache.lens.ml.Algorithm;
import org.apache.lens.ml.TrainerParam;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.rdd.RDD;

import java.util.Map;

/**
 * Created by deepak on 9/25/14.
 */

@Algorithm(
        name = "spark_single_exponential_smoothing",
        description = "Spark single exponential smoothing trainer"
)
public class SingleExponentialSmoothingForecastTrainer extends BaseForecastTrainer {

    @TrainerParam(name = "stepSize", help = "Max number of iterations",
            defaultValue = "0.1")
    private double stepSize;

    @TrainerParam(name = "smoothingFactor", help = "Decay coefficient",
            defaultValue = "100")

    private double smoothingFactor;

    public SingleExponentialSmoothingForecastTrainer(String name, String description) {
        super(name, description);
    }

    @Override
    public void parseTrainerParams(Map<String, String> params) {
        stepSize = getParamValue("step", 0.1);
        smoothingFactor = getParamValue("smoothingCoefficient", -1);
    }

    @Override
    protected BaseSparkForecastModel trainInternal(String modelId, RDD<LabeledPoint> trainingRDD) throws LensException {
        SingleExponentialSmoothingModel model = SingleExponentialSmoothingModel.train(trainingRDD, timeVariable, smoothingFactor,stepSize );
        return new BaseSparkForecastModel<SingleExponentialSmoothingModel>(modelId, model);

    }

}
