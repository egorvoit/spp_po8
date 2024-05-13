import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Интерфейс для аэропорта
interface Airport
{
    String getName();
}

// Абстрактный класс для самолета
abstract class Aircraft
{
    private int capacity;
    private int range;
    private String model;

    public Aircraft(int capacity, int range, String model) {
        this.capacity = capacity;
        this.range = range;
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRange() {
        return range;
    }

    public String getModel() {
        return model;
    }
}

// Абстрактный класс для члена экипажа
abstract class CrewMember
{
    private String name;
    private int age;

    public CrewMember(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Интерфейс для пилота
interface Pilot
{
    void flyAircraft();
    void getVoice();
    String getName();
}


// Абстрактный класс для штурмана
abstract class Navigator extends CrewMember
{
    public Navigator(String name, int age) {
        super(name, age);
    }

    public abstract void navigate();
}

// Абстрактный класс для радиста
abstract class RadioOperator extends CrewMember
{
    public RadioOperator(String name, int age) {
        super(name, age);
    }

    public abstract void speakWithEarth();
}

// Абстрактный класс для стюардессы
abstract class Stewardess extends CrewMember
{
    public Stewardess(String name, int age) {
        super(name, age);
    }

    public abstract void servePassengers();
    public abstract void conductBriefing();
}

// Класс Пилот, реализующий интерфейс Pilot
class PilotImpl extends CrewMember implements Pilot
{
    public PilotImpl(String name, int age) {
        super(name, age);
    }

    @Override
    public void flyAircraft() {
        System.out.println("Главный пилот " + getName() + " управляет самолётом");
    }

    @Override
    public void getVoice() {
        System.out.println("Помощник пилота " + getName() + " объявляет необходимую информацию пассажирам по громкоговорителю");
    }
}

// Класс Штурман, реализующий абстрактный класс Navigator
class NavigatorImpl extends Navigator
{
    public NavigatorImpl(String name, int age) {
        super(name, age);
    }

    @Override
    public void navigate() {
        System.out.println("Штурман определяет маршрут полёта...");
    }
}

// Класс Радист, реализующий абстрактный класс RadioOperator
class RadioOperatorImpl extends RadioOperator
{
    public RadioOperatorImpl(String name, int age) {
        super(name, age);
    }

    @Override
    public void speakWithEarth() {
        System.out.println("Радист " + getName() + " докладывает обстановку по рации в диспетчерский центр");
    }
}

// Класс Стюардесса, реализующий абстрактный класс Stewardess
class StewardessImpl extends Stewardess
{
    public StewardessImpl(String name, int age) {
        super(name, age);
    }

    @Override
    public void servePassengers() {
        System.out.println("Стюардесса " + getName() + " обслуживает пассажиров в самолете");
    }

    @Override
    public void conductBriefing() {
        System.out.println("Стюардесса " + getName() + " проводит инструктаж пассажиров");
    }
}

// Класс Аэропорт
class AirportImpl implements Airport
{
    private String name;

    public AirportImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Класс Самолет
class AircraftImpl extends Aircraft
{
    public AircraftImpl(int capacity, int range, String model) {
        super(capacity, range, model);
    }
}

// Класс Рейс
class Flight
{
    private Airport departureAirport;
    private Airport destinationAirport;
    private Aircraft aircraft;

    public Flight(Airport departureAirport, Airport destinationAirport, Aircraft aircraft) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.aircraft = aircraft;
    }

    public void changeDestination(String newDestination) {
        System.out.println("Рейс изменяет место назначения из " + this.destinationAirport.getName() + " в " + newDestination);
        this.destinationAirport = new AirportImpl(newDestination);
    }

    public Airport getDestinationAirport() {
        return this.destinationAirport;
    }
}

public class Main
{
    private static void getJob(List<Pilot> pilotList, Navigator navigator, RadioOperator radioOperator, List<? extends CrewMember> crewList, Airport destinationAirport) throws InterruptedException
    {
        Thread.sleep(   500);
        for (Pilot pilot : pilotList)
        {
            if (pilot != null) {
                if (pilot.getName().equals("Сорока Вадим Сергеевич")) {
                    pilot.flyAircraft();
                } else {
                    pilot.getVoice();
                }
            }
        }

        Thread.sleep(500);
        if (navigator instanceof Navigator) {
            Navigator castedNavigator = (Navigator) navigator;
            castedNavigator.navigate();
        }

        Thread.sleep(500);
        if (radioOperator instanceof RadioOperator) {
            RadioOperator castedOperator = (RadioOperator) radioOperator;
            castedOperator.speakWithEarth();
        }
        Thread.sleep(500);
        for (CrewMember crewMember : crewList)
        {
            if (crewMember instanceof Stewardess) {
                Stewardess stewardess = (Stewardess) crewMember;
                if (stewardess.getName().equals("Петрова Александра Сергеевна")) {
                    stewardess.conductBriefing();
                } else {
                    stewardess.servePassengers();
                }
            }
        }

        try {
            // Задержка выполнения кода на 3 секунды
            Thread.sleep(2000);
            System.out.println("\nРейс проходит в штатном режиме...");
            Thread.sleep(3000);

            Random random = new Random();
            int randomNumber = random.nextInt(3); // 0, 1, 2
            if (randomNumber == 0)
            {
                if (isGoodWeather())
                {
                    Thread.sleep(500);
                    System.out.println("\nВнимание!!! В процессе рейса произошло резкое ухудшение погодных условий. Конечный аэропорт " + destinationAirport.getName() + " временно недоступен для посадки!");

                    // Создаем новый объект Airport
                    Airport newDestinationAirport = new AirportImpl("Аэропорт Иваново-Северный");
                    Thread.sleep(500);
                    System.out.println("Конечный пункт прибытия изменён с " + destinationAirport.getName() + " на " + newDestinationAirport.getName());
                    // Обновляем значение destinationAirport
                    destinationAirport = newDestinationAirport;

                    try {
                        System.out.println("\nРейс проходит в штатном режиме...");
                        // Задержка выполнения кода на 2 секунды
                        Thread.sleep(2000);
                        System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                        Thread.sleep(500);
                        System.out.println("Рейс №228 был успешно завершён в другой конечной точке!");
                    } catch (InterruptedException e) {
                        // Обработка исключения, если прерывание произошло
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                    Thread.sleep(500);
                    System.out.println("Рейс №228 успешно завершён!");
                }

            } else if (randomNumber == 1) {
                Thread.sleep(500);
                System.out.println("\nГоворит главный пилот самолёта " + pilotList.get(0).getName() + "! В связи с технической неисправностью воздушного судна мы не сможем долететь до аэропорта назначения: " + destinationAirport.getName() + ". ");

                // Создаем новый объект Airport
                Airport newDestinationAirport = new AirportImpl("Аэропорт Кобылёво");
                Thread.sleep(500);
                System.out.println("Поэтому мы изменяем курс на ближайший к нам аэропорт: " + newDestinationAirport.getName() + ". Авиакомпания заранее приносит свои извенения, все подробности будут позже!");

                // Обновляем значение destinationAirport
                destinationAirport = newDestinationAirport;

                try {
                    System.out.println("\nРейс проходит в аварийном режиме...");
                    // Задержка выполнения кода на 5 секунд
                    Thread.sleep(2000);
                    System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                    Thread.sleep(500);
                    System.out.println("Рейс №228 завершён преждевременно из-за технической неисправности!");
                } catch (InterruptedException e) {
                    // Обработка исключения, если прерывание произошло
                    e.printStackTrace();
                }

            } else {
                System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                Thread.sleep(500);
                System.out.println("Рейс №228 успешно завершён!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int badWeatherCount = 0;
    private static void scheduleFlight(List<Stewardess> stewardessList, List<Pilot> pilotList, Navigator navigator, RadioOperator radioOperator, Airport destinationAirport) {
        // ваш текущий код метода scheduleFlight
       System.out.println("Ожидаем изменения погоды...");
        try {
            // Пауза на 5 секунд
            long delay = 5000;
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < delay) {
                Thread.sleep(1000); // Можно делать проверки каждую секунду
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (isGoodWeather()) {
            System.out.println("Погода улучшилась. Начинаем подготовку к рейсу... \n");
            try {
                getJob(pilotList, navigator, radioOperator, stewardessList, destinationAirport);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Увеличиваем счетчик при каждом срабатывании условия else
            badWeatherCount++;

            if (badWeatherCount < 2) {
                System.out.println("Продолжается плохая погода. Повторная проверка через 5 секунд...");
                scheduleFlight(stewardessList, pilotList, navigator, radioOperator, destinationAirport);
            } else {
                System.out.println("Продолжается плохая погода. Рейс отменён.");
            }
        }
    }

    private static int getWeatherCondition() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private static boolean isGoodWeather() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<Stewardess> stewardessList = new ArrayList<>();
        List<Pilot> pilotList = new ArrayList<>();

        // Создаем объекты классов
        Aircraft aircraft = new AircraftImpl(200, 1500, "Boeing 737 №555");
        Airport departureAirport = new AirportImpl("Аэропорт Брестский ()");
        Airport destinationAirport = new AirportImpl("Аэропорт Иваново (IWA)");

        // Создаем рейс
        Flight flight = new Flight(departureAirport, destinationAirport, aircraft);

        // Создаем и добавляем членов экипажа
        Pilot first_pilot = new PilotImpl("Сорока Вадим Сергеевич", 30);
        pilotList.add(first_pilot);
        Pilot second_pilot = new PilotImpl("Капитонов Максим Игоревич", 29);
        pilotList.add(second_pilot);

        Navigator navigator = new NavigatorImpl("Таразевич Никита Александрович", 29);
        RadioOperator radioOperator = new RadioOperatorImpl("Дорошков Александр Дмитриевич", 29);

        Stewardess first_stewardess = new StewardessImpl("Сидорова Елена Николаевна", 24);
        stewardessList.add(first_stewardess);
        Stewardess second_stewardess = new StewardessImpl("Петрова Александра Сергеевна", 23);
        stewardessList.add(second_stewardess);

        // Вывод сообщения о формировании лётной бригады
        System.out.println("Администратор сформировал лётную бригаду:");
        // Вывод списка пилотов с нумерацией
        System.out.println("Пилоты:");
        for (int i = 0; i < pilotList.size(); i++) {
            System.out.println((i + 1) + ") " + pilotList.get(i).getName());
        }
        // Вывод навигатора и радиооператора
        System.out.println("Навигатор: " + navigator.getName());
        System.out.println("Радиооператор: " + radioOperator.getName());
        // Вывод списка стюардесс с нумерацией
        System.out.println("Стюардессы:");
        for (int i = 0; i < stewardessList.size(); i++) {
            System.out.println((i + 1) + ") " + stewardessList.get(i).getName());
        }
        System.out.println("\nРейс №228: " + departureAirport.getName() + " -- " + destinationAirport.getName() + "\nСамолёт: " + aircraft.getModel() + "\nВместимость: " + aircraft.getCapacity() + "\nДальность рейса: " + aircraft.getRange());
        System.out.println("\n============================================================\n");

        int weatherCondition = getWeatherCondition();
        System.out.println(weatherCondition);
        switch (weatherCondition) {
            case 0:
                System.out.println("Солнечная погода в обоих аэропортах. Рейс разрешен.\n");
                try {
                    getJob(pilotList, navigator, radioOperator, stewardessList, destinationAirport);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 1:
                System.out.println("Сильные осадки, штормовое предупреждение в аэропорту отправления. Рейс задерживается.");
                scheduleFlight(stewardessList, pilotList, navigator, radioOperator, destinationAirport);
                break;
            case 2:
                System.out.println("Сильные осадки, штормовое предупреждение в аэропорту назначения. Рейс задерживается.");
                scheduleFlight(stewardessList, pilotList, navigator, radioOperator, destinationAirport);
                break;
            default:
                System.out.println("Непредвиденное состояние погоды.");
                scheduleFlight(stewardessList, pilotList, navigator, radioOperator, destinationAirport);
                break;
        }
    }
}
