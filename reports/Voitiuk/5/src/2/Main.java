abstract class DomesticAnimal {
    String name;
    String id;
    String characteristics;

    public DomesticAnimal(String name, String id, String characteristics) {
        this.name = name;
        this.id = id;
        this.characteristics = characteristics;
    }

    abstract void sound();
}

class Dog extends DomesticAnimal {
    public Dog(String name, String id, String characteristics) {
        super(name, id, characteristics);
    }

    @Override
    void sound() {
        System.out.println("Гав-гав!");
    }
}

class Cat extends DomesticAnimal {
    public Cat(String name, String id, String characteristics) {
        super(name, id, characteristics);
    }

    @Override
    void sound() {
        System.out.println("Мяу-мяу!");
    }
}

class Parrot extends DomesticAnimal {
    public Parrot(String name, String id, String characteristics) {
        super(name, id, characteristics);
    }

    @Override
    void sound() {
        System.out.println("Чирик-чирик!");
    }
}

public class Main {
    public static void main(String[] args) {
        DomesticAnimal[] pets = new DomesticAnimal[3];

        pets[0] = new Dog("Бобик", "1", "Бобик - активный и дружелюбный пес.");
        pets[1] = new Cat("Мурзик", "2", "Мурзик - независимая и любознательная кошка.");
        pets[2] = new Parrot("Кеша", "3", "Кеша - говорливый и яркий попугай.");

        for (DomesticAnimal pet : pets) {
            System.out.println("Имя: " + pet.name + ", ID: " + pet.id + ", Характеристики: " + pet.characteristics);
            pet.sound();
        }
    }
}
