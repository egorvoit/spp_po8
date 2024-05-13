import java.util.List;
import java.util.ArrayList;

interface Command {
    void execute();
}

class CreateOrderCommand implements Command {
    private Order order;
    private List<MenuItem> itemsToAdd;

    public CreateOrderCommand(Order order, List<MenuItem> itemsToAdd) {
        this.order = order;
        this.itemsToAdd = itemsToAdd;
    }

    @Override
    public void execute() {
        order.addItems(itemsToAdd);
        System.out.println("New order has been created: " + order);
    }
}

class CancelOrderCommand implements Command {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancel();
        System.out.println("Order has been cancelled: " + order);
    }
}

class RepeatOrderCommand implements Command {
    private OrderHistory orderHistory;
    private int orderIndex;

    public RepeatOrderCommand(OrderHistory orderHistory, int orderIndex) {
        this.orderHistory = orderHistory;
        this.orderIndex = orderIndex;
    }

    @Override
    public void execute() {
        Order orderToRepeat = orderHistory.getOrder(orderIndex);
        Order repeatedOrder = new Order();
        repeatedOrder.addItems(orderToRepeat.getItems());
        System.out.println("Repeated order has been created: " + repeatedOrder);
    }
}

class Order {
    private List<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItems(List<MenuItem> itemsToAdd) {
        items.addAll(itemsToAdd);
    }

    public void cancel() {
        items.clear();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order: ");
        if (!items.isEmpty()) {
            for (MenuItem item : items) {
                sb.append(item.toString()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        } else {
            sb.append("Empty");
        }
        return sb.toString();
    }
}

class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(int index) {
        return orders.get(index);
    }
}

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class Waiter {
    private List<Command> orders;

    public Waiter() {
        this.orders = new ArrayList<>();
    }

    public void takeOrder(Command command) {
        orders.add(command);
    }

    public void placeOrders() {
        for (Command command : orders) {
            command.execute();
        }
        orders.clear();
    }
}

public class task03 {
    public static void main(String[] args) {
        MenuItem pepperoni = new MenuItem("Pepperoni", 10.99);
        MenuItem margarita = new MenuItem("Margarita", 5.99);
        MenuItem hawaiian = new MenuItem("Hawaiian", 12.99);
        MenuItem veggie = new MenuItem("Veggie", 8.99);

        Order order = new Order();

        Waiter waiter = new Waiter();

        List<MenuItem> itemsToAdd = new ArrayList<>();
        itemsToAdd.add(pepperoni);
        itemsToAdd.add(margarita);
        itemsToAdd.add(hawaiian);
        itemsToAdd.add(veggie);
        Command createOrderCommand = new CreateOrderCommand(order, itemsToAdd);

        Command cancelOrderCommand = new CancelOrderCommand(order);

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order);
        Command repeatOrderCommand = new RepeatOrderCommand(orderHistory, 0);

        waiter.takeOrder(createOrderCommand);
        waiter.takeOrder(repeatOrderCommand);
        waiter.takeOrder(cancelOrderCommand);

        waiter.placeOrders();
    }
}
