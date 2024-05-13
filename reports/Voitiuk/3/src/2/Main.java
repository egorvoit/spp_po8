import java.util.List;
import java.util.Scanner;

public static void main(String[] args) {
    RentalSystem rentalSystem = new RentalSystem();

    rentalSystem.loadRoomsFromFile("C:/Users/egor-/IdeaProjects/lab3task2/src/rooms.txt");

    Scanner scanner = new Scanner(System.in);

    int action = 0;
    while (action != 8) {
        System.out.println("1. Печать всех комнат:");
        System.out.println("2. Печать всех свободных комнат:");
        System.out.println("3. Печать всех сданных комнат:");
        System.out.println("4. Поиск комнат по количеству комнат и этажу:");
        System.out.println("5. Получение комнат по максимальной цене аренды:");
        System.out.println("6. Получение комнат по адресу:");
        System.out.println("7. Получение комнат по площади:");
        System.out.println("8. Выход");

        action = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        switch (action) {
            case 1:
                System.out.println("Все комнаты:");
                rentalSystem.printAllRooms();
                break;
            case 2:
                System.out.println("Свободные комнаты:");
                List<Room> freeRooms = rentalSystem.getFreeRooms();
                for (Room room : freeRooms) {
                    System.out.println("Свободная комната: " + room.getAddress());
                }
                break;
            case 3:
                System.out.println("Сданные комнаты:");
                List<Room> rentedRooms = rentalSystem.getRentedRooms();
                for (Room room : rentedRooms) {
                    System.out.println("Сданная комната: " + room.getAddress());
                }
                break;
            case 4:
                System.out.println("Введите количество комнат и этаж:");
                int rooms = scanner.nextInt();
                int floor = scanner.nextInt();
                int maxFloor = scanner.nextInt();

                scanner.nextLine(); // consume newline left-over
                System.out.println("Комнаты по количеству комнат и этажу:");
                List<Room> foundRooms = rentalSystem.getRoomsByRoomsNumberAndFloor(rooms, floor, maxFloor);
                for (Room room : foundRooms) {
                    System.out.println("Найденная комната: " + room.getAddress());
                }
                break;
            case 5:
                System.out.println("Введите максимальную цену аренды:");
                double maxRentPrice = scanner.nextDouble();
                scanner.nextLine(); // consume newline left-over
                System.out.println("Комнаты по максимальной цене аренды:");
                List<Room> roomsByMaxRentPrice = rentalSystem.getRoomsByMaxRentPrice(maxRentPrice);
                for (Room room : roomsByMaxRentPrice) {
                    System.out.println("Комната по максимальной цене аренды: " + room.getAddress());
                }
                break;
            case 6:
                System.out.println("Введите адрес:");
                String address = scanner.nextLine();
                System.out.println("Комнаты по адресу:");
                List<Room> roomsByAddress = rentalSystem.getRoomsByAddress(address);
                for (Room room : roomsByAddress) {
                    System.out.println("Комната по адресу: " + room.getAddress());
                }
                break;
            case 7:
                System.out.println("Введите площадь:");
                double area = scanner.nextDouble();
                scanner.nextLine(); // consume newline left-over
                System.out.println("Комнаты по площади:");
                List<Room> roomsByArea = rentalSystem.getRoomsByArea(area);
                for (Room room : roomsByArea) {
                    System.out.println("Комната по площади: " + room.getAddress());
                }
                break;
            case 8:
                System.out.println("Выход из программы");
                break;
            default:
                System.out.println("Неверное действие");
        }
    }
}
