import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    private String name;
    private Star star;
    private List<Planet> planets;

    public StarSystem(String name, Star star) {
        this.name = name;
        this.star = star;
        this.planets = new ArrayList<>();
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public void printStarSystemInfo() {
        System.out.println("StarSystem: " + name);
        star.printStarInfo();
        System.out.println("Planets in the system:");
        for (Planet planet : planets) {
            planet.printPlanetInfo();
        }
    }

    public static void main(String[] args) {
        Star sun = new Star("Sun", "Yellow", 5.0);
        StarSystem solarSystem = new StarSystem("Solar System", sun);

        Planet mercury = new Planet("Mercury", 0.33);
        Planet venus = new Planet("Venus", 4.87);
        Planet earth = new Planet("Earth", 5.97);
        solarSystem.addPlanet(mercury);
        solarSystem.addPlanet(venus);
        solarSystem.addPlanet(earth);

        solarSystem.printStarSystemInfo();
    }
}

class Star {
    private String name;
    private String type;
    private double mass;

    public Star(String name, String type, double mass) {
        this.name = name;
        this.type = type;
        this.mass = mass;
    }

    public void printStarInfo() {
        System.out.println("Star: " + name + ", Type: " + type + ", Mass: " + mass + " Solar Masses");
    }
}

class Planet {
    private String name;
    private double mass;

    public Planet(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public void printPlanetInfo() {
        System.out.println("Planet: " + name + ", Mass: " + mass + " Earth Masses");
    }
}