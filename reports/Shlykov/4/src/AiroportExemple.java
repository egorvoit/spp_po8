import java.util.List;
import java.util.ArrayList;

abstract class Staff {
    String name;

    public Staff(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.name;
    }
}

class Crew {
    Pilot pilot;
    Navigator navigator;
    Radioman radioman;
    List<Stewardess> stewardesses;

    public Crew(Pilot pilot, Navigator navigator, Radioman radioman, List<Stewardess> stewardesses) {
        this.pilot = pilot;
        this.navigator = navigator;
        this.radioman = radioman;
        this.stewardesses = stewardesses;
    }

    @Override
    public String toString() {
        return "Crew: " + pilot + ", " + navigator + ", " + radioman + ", Stewardesses: " + stewardesses;
    }
}

class Plane {
    int capacity;
    int flightRange;

    public Plane(int capacity, int flightRange) {
        this.capacity = capacity;
        this.flightRange = flightRange;
    }

    @Override
    public String toString() {
        return "Plane: Capacity - " + capacity + ", Flight Range - " + flightRange;
    }
}

class Flight {
    Crew crew;
    Plane plane;
    Airport departureAirport;
    Airport destinationAirport;

    public Flight(Crew crew, Plane plane, Airport departureAirport, Airport destinationAirport) {
        this.crew = crew;
        this.plane = plane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    @Override
    public String toString() {
        return "Flight: " + crew + ", " + plane + ", Departure: " + departureAirport + ", Destination: " + destinationAirport;
    }
}

class Airport {
    String name;

    public Airport(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airport: " + name;
    }
}
class Administrator {
    void formCrew(Flight flight, Pilot pilot, Navigator navigator, Radioman radioman, List<Stewardess> stewardesses) {
        Crew crew = new Crew(pilot, navigator, radioman, stewardesses);
        flight.crew = crew;
    }
}

public class AiroportExemple {
    public static void main(String[] args) {
        // Создаем персонал
        Pilot pilot = new Pilot("Пилот Иван");
        Navigator navigator = new Navigator("Штурман Петр");
        Radioman radioman = new Radioman("Радист Алексей");
        Stewardess stewardess1 = new Stewardess("Стюардесса Мария");
        Stewardess stewardess2 = new Stewardess("Стюардесса Анна");

        // Создаем список стюардесс
        List<Stewardess> stewardesses = new ArrayList<>();
        stewardesses.add(stewardess1);
        stewardesses.add(stewardess2);

        // Создаем аэропорты
        Airport departureAirport = new Airport("Москва");
        Airport destinationAirport = new Airport("Санкт-Петербург");

        // Создаем самолет
        Plane plane = new Plane(180, 2000);

        // Создаем рейс без экипажа
        Flight flight = new Flight(null, plane, departureAirport, destinationAirport);

        // Создаем администратора и формируем экипаж
        Administrator admin = new Administrator();
        admin.formCrew(flight, pilot, navigator, radioman, stewardesses);

        // Теперь у нас есть рейс с экипажем
        System.out.println("Экипаж рейса: " + flight.crew );
    }
}


