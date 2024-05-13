public class Xiaomi extends Smartphone{
    public Xiaomi(String modelName, String CPU, int storageRAM, int storageROM) {
        super(modelName, CPU, storageRAM, storageROM);
    }

    @Override
    public void printInfo() {
        System.out.println("Информация о смартфоне Xiaomi:\nМодель: " + modelName +"\nПроцессор: " +
                CPU + "\nОперативная память: " + storageRAM + "Гб\nПамять: " + storageROM + "Гб");
    }
}
