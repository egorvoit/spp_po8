// Абстрактный класс Домашнее животное
abstract class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Общий метод для всех животных
    public void makeSound() {
        System.out.println("Животное издает звук.");
    }

    // Абстрактный метод для подклассов
    public abstract void move();
}

// Подкласс Собака
class Dog extends Pet {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    // Переопределение метода
    @Override
    public void makeSound() {
        System.out.println("Собака лает: Гав-гав!");
    }

    // Переопределение метода
    @Override
    public void move() {
        System.out.println("Собака бегает по двору.");
    }
}

// Подкласс Кошка
class Cat extends Pet {
    private int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    // Переопределение метода
    @Override
    public void makeSound() {
        System.out.println("Кошка мурлычет: Мур-мур-мур");
    }

    // Переопределение метода
    @Override
    public void move() {
        System.out.println("Кошка прыгает по кухонному столу.");
    }
}

// Подкласс Попугай
class Parrot extends Pet {
    private String color;

    public Parrot(String name, String color) {
        super(name);
        this.color = color;
    }

    // Переопределение метода
    @Override
    public void makeSound() {
        System.out.println("Попугай говорит: Валюша хороши, Валюша молодец");
    }

    // Переопределение метода
    @Override
    public void move() {
        System.out.println("Попугай висит вниз головой на веточке в клетке.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем массив объектов суперкласса Pet
        Pet[] pets = new Pet[3];

        // Заполняем массив объектами подклассов
        pets[0] = new Dog("Буран", "Немецкая овчарка");
        pets[1] = new Cat("Ника", 3);
        pets[2] = new Parrot("Кеша", "Пёстрый зелёный");

        // Используем объекты для моделирования ситуаций
        for (Pet pet : pets) {
            System.out.println("Имя: " + pet.getName());
            pet.makeSound();
            pet.move();
            System.out.println();
        }
    }
}
