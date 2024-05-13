import java.util.Scanner;

public class Abbreviator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();
        String abbreviation = abbreviate(input);
        System.out.println("Аббревиатура: " + abbreviation);
    }

    public static String abbreviate(String str) {
        String[] words = str.split(" ");
        StringBuilder abbreviation = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                abbreviation.append(word.charAt(0));
            }
        }

        return abbreviation.toString().toUpperCase();
    }
}
