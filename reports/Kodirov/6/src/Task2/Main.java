package Task2;

public class Main {
    public static void main(String[] args) {
        ThermometerAdapter thermometerAdapter = new ThermometerAdapter(
                new AnalogThermometer(35.0, 42.0, 10.0, 2.0));
        System.out.println("Температура на градуснике: " + thermometerAdapter.getTemperature() + " Cº");
    }
}
