public class Samsung extends Smartphone{
    public Samsung(String modelName, String CPU, int storageRAM, int storageROM) {
        super(modelName, CPU, storageRAM, storageROM);
    }

    @Override
    public void printInfo() {
        System.out.println("Информация о смартфоне Samsung:\nМодель: " + modelName +"\nПроцессор: " +
                CPU + "\nОперативная память: " + storageRAM + "Гб\nПамять: " + storageROM + "Гб");
    }
}
