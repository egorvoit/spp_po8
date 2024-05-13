package Task2;

public class ThermometerAdapter implements ElectronicThermometer {
    private AnalogThermometer analogThermometer;
    public ThermometerAdapter(AnalogThermometer analogThermometer) {
        this.analogThermometer = analogThermometer;
    }

    @java.lang.Override
    public double getTemperature() {
        return analogThermometer.getLowerLimit() + analogThermometer.getMercuryHeight() / analogThermometer.getGraduationScale();
    }
}
