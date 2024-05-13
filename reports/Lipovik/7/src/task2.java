import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class task2 extends JPanel {

    private final int width = 800;
    private final int height = 600;
    private final int maxIterations = 1000;
    private final double zoom = 300;
    private final double offsetX = -0.7;
    private final double offsetY = 0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double zx = 0;
                double zy = 0;
                double cx = (x - width / 2.0) / zoom + offsetX;
                double cy = (y - height / 2.0) / zoom + offsetY;

                int iter = maxIterations - 1;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    double temp = zx * zx - zy * zy + cx;
                    zy = 2 * zx * zy + cy;
                    zx = temp;
                    iter--;
                }

                if (iter > 0) {
                    g.setColor(Color.getHSBColor((float) ((maxIterations - iter) / (float) maxIterations), 1, 1));
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Set");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.add(new task2());
        frame.setVisible(true);
    }
}
