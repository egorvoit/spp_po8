public class Task1 {
    public static void main(String[] args) {
        int[] sequence = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            sequence[i] = Integer.parseInt(args[i]);
        }
        analyzeSequence(sequence);
    }

    public static void analyzeSequence(int[] sequence) {
        if (sequence.length == 0) {
            System.out.println("Последовательность пуста");
            return;
        }
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int sum = 0;
        long mult = 1;
        for (int num : sequence) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            sum += num;
            mult *= num;
        }
        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + mult);
    }
}