import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalSystem {
    private List<Room> rooms;

    public RentalSystem() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public List<Room> getFreeRooms() {
        return rooms.stream().filter(room -> !room.isRented()).collect(Collectors.toList());
    }

    public List<Room> getRentedRooms() {
        return rooms.stream().filter(Room::isRented).collect(Collectors.toList());
    }

    public List<Room> findRooms(int rooms, int floor, double area) {
        return this.rooms.stream()
                .filter(room -> room.getRooms() == rooms && room.getFloor() == floor && Math.abs(room.getArea() - area) <= 10)
                .collect(Collectors.toList());
    }

    public void rentRoom(Room room) {
        if (rooms.contains(room) && !room.isRented()) {
            room.setRented(true);
        }
    }

    public List<Room> getRoomsByRoomsNumber(int rooms) {
        return this.rooms.stream().filter(room -> room.getRooms() == rooms).collect(Collectors.toList());
    }

    public List<Room> getRoomsByRoomsNumberAndFloor(int rooms, int minFloor, int maxFloor) {
        return this.rooms.stream().filter(room -> room.getRooms() == rooms && room.getFloor() >= minFloor && room.getFloor() <= maxFloor).collect(Collectors.toList());
    }
    public List<Room> getRoomsByMaxRentPrice(double maxRentPrice) {
        return this.rooms.stream().filter(room -> room.getRentPrice() <= maxRentPrice).collect(Collectors.toList());
    }
    public List<Room> getRoomsByAddress(String address) {
        return this.rooms.stream().filter(room -> room.getAddress().equals(address)).collect(Collectors.toList());
    }


    public List<Room> getRoomsByArea(double area) {
        return rooms.stream().filter(room -> room.getArea() > area).collect(Collectors.toList());
    }

    public void printAllRooms() {
        for (Room room : rooms) {
            System.out.println("Количество комнат: " + room.getRooms());
            System.out.println("Площадь: " + room.getArea());
            System.out.println("Этаж: " + room.getFloor());
            System.out.println("Адрес: " + room.getAddress());
            System.out.println("Цена аренды: " + room.getRentPrice());
            System.out.println("Сдана: " + (room.isRented() ? "Да" : "Нет"));
            System.out.println("------------------------");
        }
    }

    public void loadRoomsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    int rooms = Integer.parseInt(values[0]);
                    double area = Double.parseDouble(values[1]);
                    int floor = Integer.parseInt(values[2]);
                    String address = values[3].replace("\"", ""); // убираем кавычки
                    double rentPrice = Double.parseDouble(values[4]);
                    boolean isRented = Boolean.parseBoolean(values[5]);
                    this.addRoom(new Room(rooms, area, floor, address, rentPrice, isRented));
                } catch (NumberFormatException e) {
                    System.err.println("Could not parse line: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}