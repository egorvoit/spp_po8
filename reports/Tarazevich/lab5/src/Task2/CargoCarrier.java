package Task2;

/*
TODO:
    В следующих заданиях требуется создать суперкласс (абстрактный класс, интерфейс) и определить
    общие методы для данного класса. Создать подклассы, в которых добавить специфические
    свойства и методы. Часть методов переопределить. Создать массив объектов суперкласса и
    заполнить объектами подклассов. Объекты подклассов идентифицировать конструктором по имени
    или идентификационному номеру.

TODO:
    Создать суперкласс Грузоперевозчик и подклассы Самолет, Поезд, Автомобиль.
    Определить время и стоимость перевозки для указанных городов и расстояний.
 */
public abstract class CargoCarrier implements Positionable {
    private static int nextPersonId = 1;
    private String name;
    private final int id;
    private Position currentPosition = new Position(0, 0);

    public CargoCarrier(String name){
        this.name = name;
        id = nextPersonId++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveToPosition(Position position) {
        this.currentPosition = position;
    }

    @Override
    public Position getPosition(){
        return currentPosition;
    }
    @Override
    public void setPosition(Position position){
        currentPosition = position;
    }

    public abstract double getTransportationTime(Positionable positionable);

    public abstract double getTransportationCost(Positionable positionable);
}
