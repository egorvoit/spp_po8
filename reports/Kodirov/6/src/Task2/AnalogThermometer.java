package Task2;

public class AnalogThermometer {
    private final double lowerLimit;
    private final double upperLimit;
    private double mercuryHeight;
    private final double graduationScale;

    public AnalogThermometer(double lowerLimit, double upperLimit, double mercuryHeight, double graduationScale) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.mercuryHeight = mercuryHeight;
        this.graduationScale = graduationScale;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public double getMercuryHeight() {
        return mercuryHeight;
    }

    public double getGraduationScale() {
        return graduationScale;
    }

    public void setMercuryHeight(double mercuryHeight) {
        if (mercuryHeight < 0) {
            mercuryHeight = lowerLimit;
            return;
        }

        if (lowerLimit + mercuryHeight / graduationScale > upperLimit) {
            mercuryHeight = lowerLimit;
            return;
        }

        this.mercuryHeight = mercuryHeight;
    }
}
