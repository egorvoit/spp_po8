import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int length = scanner.nextInt();
        long[] array = new long[length];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextLong();
        }
        System.out.print("Введите элемент для удаления: ");
        long elementToRemove = scanner.nextLong();
        long[] newArray = removeElement(array, elementToRemove);
        System.out.println("Массив после удаления элемента " + elementToRemove + ":");
        for (long num : newArray) {
            System.out.print(num + " ");
        }
    }
    public static long[] removeElement(long[] array, long element) {
        int found = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                found = i;
                break;
            }
        }

        if (found == -1) {
            return array;
        } else {
            long[] newArray = new long[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, found);
            System.arraycopy(array, found + 1, newArray, found, array.length - found - 1);
            return newArray;
        }
    }
}
