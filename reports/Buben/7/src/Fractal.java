import javax.swing.*;
import java.awt.*;

public class Fractal extends JPanel
{
    private int recDepth;
    private static Color[] colors = {
            Color.red, Color.blue, Color.green,
            Color.orange, Color.black, Color.magenta, Color.darkGray
    };

    public Fractal(int recDepth)
    {
        super();
        this.recDepth = recDepth;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawFractal(g, getWidth() / 2, getHeight() / 2, 140, 0);
    }

    private void drawFractal(Graphics graphics, int x, int y, int size, int depth)
    {
        if (depth >= recDepth) return;

        graphics.setColor(colors[depth % colors.length]);
        graphics.drawLine(x - size, y, x + size, y);
        graphics.drawLine(x - size, y - size, x - size, y + size);
        graphics.drawLine(x + size, y - size, x + size, y + size);

        drawFractal(graphics, x - size, y - size, size / 2, depth + 1);
        drawFractal(graphics, x + size, y - size, size / 2, depth + 1);
        drawFractal(graphics, x - size, y + size, size / 2, depth + 1);
        drawFractal(graphics, x + size, y + size, size / 2, depth + 1);
    }
}