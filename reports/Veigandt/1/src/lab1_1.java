public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Необходимо передать количество чисел в качестве аргумента.");
            return;
        }

        int n = Integer.parseInt(args[0]);

        if (n <= 0) {
            System.out.println("Количество чисел должно быть больше нуля.");
            return;
        }

        if (args.length != n + 1) {
            System.out.println("Недостаточно чисел для ввода.");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(args[i]);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        int range = max - min;
        System.out.println("Размах последовательности: " + range);
    }
}