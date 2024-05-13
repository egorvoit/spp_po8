import java.util.Scanner;

public class MatrixTransposer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк матрицы:");
        int rows = scanner.nextInt();

        System.out.println("Введите количество столбцов матрицы:");
        int cols = scanner.nextInt();

        double[][] originalMatrix = new double[rows][cols];

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                originalMatrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] transposedMatrix = transpose(originalMatrix);

        System.out.println("Оригинальная матрица:");
        printMatrix(originalMatrix);

        System.out.println("\nТранспонированная матрица:");
        printMatrix(transposedMatrix);
    }

    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
