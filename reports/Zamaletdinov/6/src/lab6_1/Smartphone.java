public abstract class Smartphone {
    public String modelName;
    public String CPU;
    public int storageRAM;
    public int storageROM;

    public Smartphone(String modelName, String CPU, int storageRAM, int storageROM) {
        this.modelName = modelName;
        this.CPU = CPU;
        this.storageRAM = storageRAM;
        this.storageROM = storageROM;
    }

    public abstract void printInfo();
}
