public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.addProduct("Milk", 2.5);
        payment.addProduct("Bread", 1.0);
        payment.addProduct("Oranges", 3.0);

        payment.printList();
        System.out.println("Full Cost: " + payment.getFullCost()+"\n");

        payment.addProduct("Ice-cream", 5.0);
        payment.removeProduct("Milk");
        payment.printList();
        System.out.println("Full Cost: " + payment.getFullCost());

    }
}