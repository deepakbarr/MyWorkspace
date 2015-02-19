package org.apache.lens.ml.spark.forecast;


import lombok.Getter;
import lombok.Setter;

public class AccuracyIndicators {

    /**
     * Arithmetic mean of the errors.
     */
    @Getter @Setter
    private double bias;

    /**
     * Mean Absolute Deviation.
     */
    @Getter @Setter
    private double mad;

    /**
     * Mean Absolute Percentage Error.
     */
    @Getter @Setter
    private double mape;

    /**
     * Mean Square of the Error.
     */
    @Getter @Setter
    private double mse;

    /**
     * Sum of the Absolute Errors.
     */
    @Getter @Setter
    private double sae;

    /**
     * Default constructor. Initializes all accuracy indicators to their
     * "worst" possible values - generally this means some large number,
     * indicating "very" inaccurate.
     */
    public AccuracyIndicators() {
        bias = mad = mape = mse = sae = Double.MAX_VALUE;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(" MAPE = " + mape);
        sb.append(",");
        sb.append(" MSE = " + mse);
        sb.append(",");
        sb.append(" MAD = " + mad);
        sb.append(",");
        sb.append(" SAE = " + sae);
        sb.append(",");
        sb.append(" Bias= " + bias);
        return sb.toString();
    }
}