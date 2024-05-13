import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of the file: ");
        String fileName = scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lexemes = line.split("[\\s,.!?;:]+");
                for (int i = lexemes.length - 1; i >= 0; i--) {
                    System.out.println(String.join(" ", lexemes[i]));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}