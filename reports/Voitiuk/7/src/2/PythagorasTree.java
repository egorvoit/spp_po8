import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;

public class PythagorasTree extends JFrame {

    private double angle; 
    private int startX, startY;
    private int lineLength;
    private int depth;

    public PythagorasTree() {
        try {
            File file = new File("C:/Users/egor-/IdeaProjects/lab7task2/src/patameters.txt");
            Scanner scanner = new Scanner(file);
            this.angle = scanner.nextDouble();
            this.startX = scanner.nextInt();
            this.startY = scanner.nextInt();
            this.lineLength = scanner.nextInt();
            this.depth = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * this.lineLength);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * this.lineLength);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - this.angle, depth - 1);
        drawTree(g, x2, y2, angle + this.angle, depth - 1);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawTree(g, this.startX, this.startY, -90, this.depth);
    }

    public static void main(String[] args) {
        new PythagorasTree().setVisible(true);
    }
}
