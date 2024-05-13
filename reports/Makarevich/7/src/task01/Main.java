package task01;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(500, 500);
        task01 panel = new task01();
        window.add(panel);
        window.setVisible(true);
    }
}
