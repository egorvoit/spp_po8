import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BouncingCircle extends JFrame {
    int x, y, r; // координаты и радиус
    int dx, dy; // приращение
    Thread t;
    volatile boolean running = false;

    public BouncingCircle() {
        try {
            Scanner scanner = new Scanner(new File("C:/Users/egor-/IdeaProjects/lab7task1/src/parameters.txt"));
            x = scanner.nextInt();
            y = scanner.nextInt();
            r = scanner.nextInt();
            dx = scanner.nextInt();
            dy = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.black);
                g.fillOval(x-r, y-r, r*2, r*2);
            }
        };

        add(panel);
        setVisible(true);

        t = new Thread(() -> {
            running = true;
            while (running) {
                if ((x - r + dx < 0) || (x + r + dx > getWidth())) dx = -dx;
                if ((y - r + dy < 0) || (y + r + dy > getHeight())) dy = -dy;
                x += dx;  y += dy;
                panel.repaint();
                try { Thread.sleep(100); }
                catch (InterruptedException e) { }
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        new BouncingCircle();
    }
}
