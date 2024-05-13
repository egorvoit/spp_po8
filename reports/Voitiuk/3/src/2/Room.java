public class Room {
    private int rooms;
    private double area;
    private int floor;
    private String address;
    private double rentPrice;
    private boolean isRented;

    public Room(int rooms, double area, int floor, String address, double rentPrice, boolean isRented) {
        this.rooms = rooms;
        this.area = area;
        this.floor = floor;
        this.address = address;
        this.rentPrice = rentPrice;
        this.isRented = isRented;
    }

    // getters
    public int getRooms() {
        return rooms;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public String getAddress() {
        return address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public boolean isRented() {
        return isRented;
    }

    // setters
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
