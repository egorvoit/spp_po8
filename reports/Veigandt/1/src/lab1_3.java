import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длинну строки: ");
        int length = scanner.nextInt();
        System.out.print("Только ASCII ?: 1-Да, 2-Нет ");
        int mode = scanner.nextInt();
        boolean asciiOnly;
        if (mode == 1) {
            asciiOnly = true;
        } else {
            asciiOnly = false;
        }
        System.out.println(randomString(length, asciiOnly));

    }

    static String randomString(int length, boolean asciiOnly){
        String string = "";
        Random random = new Random();
        int symbolCode;
        if (asciiOnly){
            for (int i = 0; i < length; i++) {
                symbolCode = Math.abs(random.nextInt(126 - 33 + 1) + 33);
                string = string + (char) symbolCode;
            }

        } else {
            for (int i = 0; i < length; i++) {
                symbolCode = Math.abs(random.nextInt(512));
                string = string + (char) symbolCode;
            }
        }
        return string;
    }
}
