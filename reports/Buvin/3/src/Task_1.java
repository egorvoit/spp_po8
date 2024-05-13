import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину стороны A: ");
        double sideA = scanner.nextDouble();

        System.out.println("Введите длину стороны B: ");
        double sideB = scanner.nextDouble();

        System.out.println("Введите длину стороны C: ");
        double sideC = scanner.nextDouble();

        RightTriangle triangle = new RightTriangle(sideA, sideB, sideC);

        System.out.println("Длины сторон исходного треугольника:");
        System.out.println("Сторона A: " + triangle.getSideA());
        System.out.println("Сторона B: " + triangle.getSideB());
        System.out.println("Сторона C: " + triangle.getSideC());

        System.out.println("Треугольник существует: " + triangle.isRightTriangle());

        System.out.println("Площадь треугольника: " + triangle.calculateArea());

        System.out.println("Периметр треугольника: " + triangle.calculatePerimeter());

        RightTriangle anotherTriangle = new RightTriangle(3, 4, 5);

        System.out.println("Длины сторон второго треугольника:");
        System.out.println("Сторона A: " + anotherTriangle.getSideA());
        System.out.println("Сторона B: " + anotherTriangle.getSideB());
        System.out.println("Сторона C: " + anotherTriangle.getSideC());
        System.out.println("Треугольники исходный и второй равны: " + triangle.equals(anotherTriangle));

        RightTriangle anotherTriangle1 = new RightTriangle(4, 3, 5);

        System.out.println("Длины сторон третьего треугольника:");
        System.out.println("Сторона A: " + anotherTriangle1.getSideA());
        System.out.println("Сторона B: " + anotherTriangle1.getSideB());
        System.out.println("Сторона C: " + anotherTriangle1.getSideC());
        System.out.println("Треугольники исходный и третий равны: " + triangle.equals(anotherTriangle1));
    }
}
class RightTriangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public RightTriangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public boolean isRightTriangle() {
        return sideA * sideA + sideB * sideB == sideC * sideC ||
                sideA * sideA + sideC * sideC == sideB * sideB ||
                sideB * sideB + sideC * sideC == sideA * sideA;
    }

    public double calculateArea() {
        return 0.5 * sideA * sideB;
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "RightTriangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RightTriangle that = (RightTriangle) o;

        if (Double.compare(that.sideA, sideA) != 0) return false;
        if (Double.compare(that.sideB, sideB) != 0) return false;
        return Double.compare(that.sideC, sideC) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(sideA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}