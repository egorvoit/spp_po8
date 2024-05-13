public class AnalogThermometer {
    private final double lowerLimit;
    private final double upperLimit;
    private double mercuryHeight;
    private final double unitOfMeasurement;

    public AnalogThermometer(double _lowerLimit, double _upperLimit, double _mercuryHeight, double _unitOfMeasurement) {
        this.lowerLimit = _lowerLimit;
        this.upperLimit = _upperLimit;
        this.mercuryHeight = _mercuryHeight;
        this.unitOfMeasurement = _unitOfMeasurement;
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

    public double getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setMercuryHeight(double mercuryHeight) {
        if (mercuryHeight < 0) {
            mercuryHeight = lowerLimit;
            return;
        }

        if (lowerLimit + mercuryHeight / unitOfMeasurement > upperLimit) {
            mercuryHeight = upperLimit;
            return;
        }

        this.mercuryHeight = mercuryHeight;
    }
}
