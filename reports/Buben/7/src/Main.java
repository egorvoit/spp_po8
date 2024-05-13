import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    private static Rectangle rectangle;
    private static Point[] points;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты верхнего левого угла прямоугольника (x, y):");
        double topLeftX = scanner.nextDouble();
        double topLeftY = scanner.nextDouble();
        Point topLeftPoint = new Point(topLeftX, topLeftY);

        System.out.println("Введите координаты нижнего правого угла прямоугольника (x, y):");
        double bottomRightX = scanner.nextDouble();
        double bottomRightY = scanner.nextDouble();
        Point bottomRightPoint = new Point(bottomRightX, bottomRightY);

        rectangle = new Rectangle(topLeftPoint, bottomRightPoint);

        System.out.println("Введите количество точек:");
        int n = scanner.nextInt();
        points = new Point[n];
        System.out.println("Введите координаты точек (x, y):");
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        scanner.close();

        System.out.println("Точки, которые находятся внутри прямоугольника:");
        for (Point point : points) {
            if (rectangle.contains(point)) {
                System.out.println("(" + point.getX() + ", " + point.getY() + ")");
            }
        }

        System.out.println("Точки, которые не находятся внутри прямоугольника:");
        for (Point point : points) {
            if (!rectangle.contains(point)) {
                System.out.println("(" + point.getX() + ", " + point.getY() + ")");
            }
        }


        JFrame frame = new JFrame("Rectangle and Points Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }


    private static void draw(Graphics g) {

        int topLeftX = (int) rectangle.getTopLeftX();
        int topLeftY = (int) rectangle.getTopLeftY();
        int bottomRightX = (int) rectangle.getBottomRightX();
        int bottomRightY = (int) rectangle.getBottomRightY();
        g.drawRect(topLeftX, topLeftY, bottomRightX - topLeftX, bottomRightY - topLeftY);

        for (Point point : points) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            g.fillOval(x, y, 3, 3);
        }


        for (Point point : points) {
            if (rectangle.contains(point)) {
                g.setColor(Color.GREEN);
                int x = (int) point.getX();
                int y = (int) point.getY();
                g.fillOval(x, y, 5, 5);
            } else {
                g.setColor(Color.RED);
                int x = (int) point.getX();
                int y = (int) point.getY();
                g.fillOval(x, y, 5, 5);
            }
        }
    }
}