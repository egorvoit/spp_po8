import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Task2 extends JFrame {
    public Task2() {
        setTitle("Fractal");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter recursion depth: ");
        int recursionDepth = scanner.nextInt();

        Fractal fractal = new Fractal(recursionDepth);
        fractal.setBackground(Color.WHITE);
        getContentPane().add(fractal);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task2::new);
    }
}