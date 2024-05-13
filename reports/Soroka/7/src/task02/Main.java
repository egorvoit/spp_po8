import javax.swing.*;
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Дракончеки");
        window.setSize(600, 600);
        System.out.print("Введите количество итераций: ");
        window.setContentPane(new DragonCu(new Scanner(System.in).nextInt()));
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}