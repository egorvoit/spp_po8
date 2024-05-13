public class AnalogAdapter implements ElectronicThermometer{
    public AnalogThermometer analogThermometer;

    public AnalogAdapter(AnalogThermometer analogThermometer) {
        this.analogThermometer = analogThermometer;
    }

    @Override
    public double getTemperature() {
        return analogThermometer.getLowerLimit() + analogThermometer.getMercuryHeight() / analogThermometer.getGradeScale();
    }
}