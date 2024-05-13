package org.example.lab7_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JuliaSet extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    private double cRe = -0.7;
    private double cIm = 0.27015;
    private int maxIterations = 1000;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        redrawJuliaSet(gc);

        TextField cReField = new TextField(Double.toString(cRe));
        TextField cImField = new TextField(Double.toString(cIm));
        TextField maxIterationsField = new TextField(Integer.toString(maxIterations));
        Button drawButton = new Button("Draw");
        drawButton.setOnAction(event -> {
            try {
                cRe = Double.parseDouble(cReField.getText());
                cIm = Double.parseDouble(cImField.getText());
                maxIterations = Integer.parseInt(maxIterationsField.getText());
                redrawJuliaSet(gc);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод");
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(
                new HBox(new Label("c Real: "), cReField),
                new HBox(new Label("c Imaginary: "), cImField),
                new HBox(new Label("Max Iterations: "), maxIterationsField),
                drawButton
        );

        StackPane root = new StackPane();
        root.getChildren().addAll(canvas, vbox);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Julia Set");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void redrawJuliaSet(GraphicsContext gc) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double z_re = -2.0 + (x * (4.0 / WIDTH));
                double z_im = -2.0 + (y * (4.0 / HEIGHT));

                int iterations = 0;
                while (iterations < maxIterations && (z_re * z_re + z_im * z_im) < 4) {
                    double new_re = z_re * z_re - z_im * z_im + cRe;
                    double new_im = 2 * z_re * z_im + cIm;
                    z_re = new_re;
                    z_im = new_im;
                    iterations++;
                }

                double t = (double) iterations / maxIterations;
                Color color = Color.hsb(360 * t, 1.0, 1.0);
                gc.setFill(color);
                gc.fillRect(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

