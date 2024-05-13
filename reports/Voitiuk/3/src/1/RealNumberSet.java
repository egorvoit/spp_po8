import java.util.Scanner;

public class RealNumberSet {
    private double[] numbers;
    private int size;

    public RealNumberSet(int capacity) {
        this.numbers = new double[capacity];
        this.size = 0;
    }

    public boolean add(double number) {
        if (size < numbers.length) {
            numbers[size] = number;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(double number) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == number) {
                System.arraycopy(numbers, i + 1, numbers, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(double number) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(numbers[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RealNumberSet other = (RealNumberSet) obj;
        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (numbers[i] != other.numbers[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите мощность множества:");
        int capacity = scanner.nextInt();
        RealNumberSet set = new RealNumberSet(capacity);

        while (true) {
            System.out.println("Выберите действие: 1 - добавить число, 2 - проверить число, 3 - удалить число, 4 - вывести множество, 5 - выйти");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Введите число для добавления в множество:");
                    double numberToAdd = scanner.nextDouble();
                    set.add(numberToAdd);
                    break;
                case 2:
                    System.out.println("Введите число для проверки его принадлежности множеству:");
                    double numberToCheck = scanner.nextDouble();
                    System.out.println("Принадлежит ли " + numberToCheck + " множеству? " + set.contains(numberToCheck));
                    break;
                case 3:
                    System.out.println("Введите число для удаления из множества:");
                    double numberToRemove = scanner.nextDouble();
                    set.remove(numberToRemove);
                    break;
                case 4:
                    System.out.println("Множество: " + set);
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 5.");
                    break;
            }
        }
    }

}
