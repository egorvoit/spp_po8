public class task2 {
    public static void main(String[] args) {
        ThermometerAdapter thermometerAdapter = new ThermometerAdapter(
                new AnalogThermometer(35.0, 42.0, 10.0, 2.0));
        System.out.println("Temperature on the thermometer: " + thermometerAdapter.getTemperature() + " C");
    }
}