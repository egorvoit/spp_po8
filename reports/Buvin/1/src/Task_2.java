public class Task_2 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough arguments. Please indicate the array elements and the number of shift positions.");
            return;
        }

        double[] array = new double[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            array[i] = Double.parseDouble(args[i]);
        }

        int shift = Integer.parseInt(args[args.length - 1]);

        shiftRight(array, shift);

        System.out.println("Array after shift by " + shift + " \n" + "positions to the right:");
        printArray(array);
    }

    public static void shiftRight(double[] array, int shift) {
        int n = array.length;
        shift %= n;

        double[] temp = new double[n];
        for (int i = 0; i < n; i++) {
            temp[(i + shift) % n] = array[i];
        }

        System.arraycopy(temp, 0, array, 0, n);
    }

    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}