interface CarFunctionality {
    void honk();
    void manipulateDoors();
    void startEngine();
}

class BMWFunctionality implements CarFunctionality {
    @Override
    public void honk() {
        System.out.println("BMW is sounding its horn!");
    }

    @Override
    public void manipulateDoors() {
        System.out.println("Your BMW's doors have been adjusted.");
    }

    @Override
    public void startEngine() {
        System.out.println("BMW engine is roaring!");
    }
}

class AudiFunctionality implements CarFunctionality {
    @Override
    public void honk() {
        System.out.println("Audi is beeping its horn!");
    }

    @Override
    public void manipulateDoors() {
        System.out.println("Your Audi's doors are now secured.");
    }

    @Override
    public void startEngine() {
        System.out.println("Audi's engine is purring!");
    }
}

abstract class Car {
    protected CarFunctionality functionality;

    public Car(CarFunctionality functionality) {
        this.functionality = functionality;
    }

    abstract void activateSignaling();
    abstract void manipulateDoors();
    abstract void startEngine();
}

class BMWCar extends Car {
    public BMWCar(CarFunctionality functionality) {
        super(functionality);
    }

    @Override
    void activateSignaling() {
        functionality.honk();
    }

    @Override
    void manipulateDoors() {
        functionality.manipulateDoors();
    }

    @Override
    void startEngine() {
        functionality.startEngine();
    }
}

class AudiCar extends Car {
    public AudiCar(CarFunctionality functionality) {
        super(functionality);
    }

    @Override
    void activateSignaling() {
        functionality.honk();
    }

    @Override
    void manipulateDoors() {
        functionality.manipulateDoors();
    }

    @Override
    void startEngine() {
        functionality.startEngine();
    }
}

public class task02 {
    public static void main(String[] args) {
        Car bmw = new BMWCar(new BMWFunctionality());
        System.out.println("BMW Client:");
        bmw.activateSignaling();
        bmw.manipulateDoors();
        bmw.startEngine();

        System.out.println("===================================");

        Car audi = new AudiCar(new AudiFunctionality());
        System.out.println("Audi Client:");
        audi.activateSignaling();
        audi.manipulateDoors();
        audi.startEngine();
    }
}

