import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        final ArrayList<String> strings = new ArrayList<String>();
        strings.add("Ля ля ля лямачки а у меня в голове ба ба бабачьки");
        strings.add("Бере бере бере бара бара бара бере бара бере");
        strings.add("Я хочу автомамонта (");
        strings.add("Били Джиин сделал грязное дело в кувшин.... Ау ау.... АУУУУУУУУУУ");
        strings.add("Ай вон ю май ловли анджел ай лов ю май френд чмоки чпоки");
        strings.add("Не каждому дано когда в задаче написано имеется.... афу вываливаем со штанофф");

        final JFrame frame = new JFrame("Движение по экрану строк из массива строк");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setVisible(true);
        frame.setLayout(null);
        final JLabel lbl = new JLabel();
        lbl.setLocation(-1, 0);
        lbl.setSize(400, 20);
        frame.add(lbl);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        Timer timer = new Timer(50, new ActionListener()
        {
            int speedX, speedY;
            Random rnd = new Random();
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                Point loc = lbl.getLocation();
                if (loc.x > frame.getWidth() || loc.y > frame.getHeight() || loc.x < 0
                        || loc.y < 0) {
                    lbl.setLocation(frame.getWidth()/2, frame.getHeight()/2);
                    speedX = -5+rnd.nextInt(10);
                    speedY = -5+rnd.nextInt(10);
                    lbl.setText(strings.get(rnd.nextInt(strings.size()-1)));
                } else {
                    lbl.setLocation(loc.x + speedX, loc.y + speedY);
                }
            }});
        timer.start();
    }
}