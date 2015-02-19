package org.apache.lens.ml.spark.forecast;

import org.apache.lens.ml.LabelledPrediction;
import org.apache.lens.ml.MLModel;
import org.apache.lens.ml.MultiPrediction;

import java.util.List;

public class ForecastingModel extends MLModel<MultiPrediction> {

    static double TOLERANCE = 0.00000001;


    @Override
    public MultiPrediction predict(Object... args) {
        return new ForecastingPredictions(null);
    }

    public static class ForecastingPredictions implements MultiPrediction {
        private final List<LabelledPrediction> values;

        public ForecastingPredictions(List<LabelledPrediction> values) {
            this.values = values;
        }

        @Override
        public List<LabelledPrediction> getPredictions() {
            return values;
        }
    }

    public static class ForecastingLabel implements LabelledPrediction<Long, Double> {
        private final Long timestamp;
        private final double value;

        public ForecastingLabel(long timestamp, double value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public Long getLabel() {
            return timestamp;
        }

        @Override
        public Double getPrediction() {
            return value;
        }
    }


}
