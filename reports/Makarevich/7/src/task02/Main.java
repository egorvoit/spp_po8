package task02;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(600, 600);
        task02 panel = new task02(6);
        window.add(panel);
        window.setVisible(true);
    }
}