// Определяем интерфейс Корабль
interface Ship {
    void sail();
}

// Реализация интерфейса Корабль: класс ГрузовойКорабль
class CargoShip implements Ship {
    @Override
    public void sail() {
        System.out.println("Грузовой корабль плывет");
    }

    // Метод специфичный для грузового корабля
    public void loadCargo() {
        System.out.println("Грузовой корабль загружает груз");
    }
}

// Реализация интерфейса Корабль: класс Танкер
class Tanker implements Ship {
    @Override
    public void sail() {
        System.out.println("Танкер плывет");
    }

    // Метод специфичный для танкера
    public void loadOil() {
        System.out.println("Танкер загружает нефть");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        // Полиморфизм: создаем объекты разных классов, но через одинаковый интерфейс
        Ship ship1 = new CargoShip();
        Ship ship2 = new Tanker();

        // Вызываем общий метод для всех кораблей
        ship1.sail();
        ship2.sail();

        // Вызываем методы, специфичные для каждого типа корабля
        ((CargoShip) ship1).loadCargo(); // Приведение типов, так как ship1 объявлен как Ship
        ((Tanker) ship2).loadOil(); // Приведение типов, так как ship2 объявлен как Ship
    }
}