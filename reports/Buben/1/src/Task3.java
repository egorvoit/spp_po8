import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean result = isPalindrome(str);
        System.out.println("Введенная строка является палиндромом: " + result);

    }

    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}