public class Main {
    public static void main(String[] args) {
        AnalogThermometer analogThermometer = new AnalogThermometer(35,42);
        AnalogAdapter analogAdapter = new AnalogAdapter(analogThermometer);
        analogThermometer.setMercuryHeight(16);
        System.out.println("Температура: " + analogAdapter.getTemperature() + "C°");
    }
}