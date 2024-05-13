public class rovnotriangle {
    private double sideA;

    public rovnotriangle(double sideA) {
        this.sideA = sideA;
    }

    public double SideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double peremiter() {
        return 3 * sideA;
    }

    public double square() {
        return (Math.sqrt(3) / 4) * sideA * sideA;
    }

    public boolean existornot() {
        return 2 * sideA > sideA;
    }

    public boolean sidesequale() {
        return (sideA == sideA);
    }

    @Override
    public String toString() {
        return "sideA: " + sideA;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        rovnotriangle other = (rovnotriangle) obj;
        return sideA == other.sideA;
    }

    public static void main(String[] args) {
        rovnotriangle triangle1 = new rovnotriangle(2);
        rovnotriangle triangle2 = new rovnotriangle(4);

        System.out.println("Первый треугольник: " + triangle1);
        System.out.println("Периметр треугольника : " + triangle1.peremiter());
        System.out.println("Площадь треугольника : " + triangle1.square());
        System.out.println("Существует ли треугольник ? " + triangle1.existornot());
        System.out.println("Является ли треугольник  равностаронним? " + triangle1.sidesequale());

        System.out.println("\nВторой треугольник : " + triangle2);
        System.out.println("Периметр треугольника : " + triangle2.peremiter());
        System.out.println("Площадь треугольника : " + triangle2.square());
        System.out.println("Существует ли треугольник ? " + triangle2.existornot());
        System.out.println("Является ли треугольник  равностаронним? " + triangle2.sidesequale());

        System.out.println("\nРавны ли треугольники  ? " + triangle1.equals(triangle2));

    }
}
