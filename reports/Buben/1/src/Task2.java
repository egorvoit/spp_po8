import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int arr_size = scanner.nextInt();
        double[] array = new double[arr_size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < arr_size; i++) {
            array[i] = scanner.nextDouble();
        }

        System.out.println("Введенный массив:");
        for (double el : array) {
            System.out.print(el + " ");
        }

        reverse(array);

        System.out.println("\nМассив после reverse:");
        for (double el : array) {
            System.out.print(el + " ");
        }
    }

    static void reverse(double[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            double temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}