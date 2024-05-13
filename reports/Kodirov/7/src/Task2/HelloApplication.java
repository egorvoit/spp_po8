package org.example.task2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class HelloApplication extends Application {
    private Canvas canvas;
    private GraphicsContext gc;
    private TextField realStartField;
    private TextField imaginaryStartField;
    private TextField realWidthField;
    private TextField imaginaryHeightField;
    private Button drawButton;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        drawButton = new Button("Нарисовать множество Мальдеброта");
        drawButton.setStyle("-fx-background-color: #F39C63; -fx-text-fill: white; -fx-font-weight: bold;");
        drawButton.setAlignment(Pos.CENTER);
        drawButton.setOnAction(e -> drawMandelbrotSet());

        Label realStartLabel = new Label("Начальное значение действительной части:");
        realStartLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        realStartField = new TextField("-2.0");
        realStartField.setPrefWidth(60);

        Label imaginaryStartLabel = new Label("Начальное значение мнимой части:");
        imaginaryStartLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        imaginaryStartField = new TextField("-1.25");
        imaginaryStartField.setPrefWidth(60);

        Label realWidthLabel = new Label("Действительная ширина:");
        realWidthLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        realWidthField = new TextField("3.0");
        realWidthField.setPrefWidth(60);

        Label imaginaryHeightLabel = new Label("Мнимая высота:");
        imaginaryHeightLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        imaginaryHeightField = new TextField("2.5");
        imaginaryHeightField.setPrefWidth(60);

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #2E3348;");

        HBox buttonContainer = new HBox();
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().add(drawButton);

        root.getChildren().addAll(canvas, realStartLabel, realStartField, imaginaryStartLabel, imaginaryStartField,
                realWidthLabel, realWidthField, imaginaryHeightLabel, imaginaryHeightField, buttonContainer);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Задание 2");
        primaryStage.show();
    }

    private void drawMandelbrotSet() {
        double realStart = Double.parseDouble(realStartField.getText());
        double imaginaryStart = Double.parseDouble(imaginaryStartField.getText());
        double realWidth = Double.parseDouble(realWidthField.getText());
        double imaginaryHeight = Double.parseDouble(imaginaryHeightField.getText());

        double realEnd = realStart + realWidth;
        double imaginaryEnd = imaginaryStart + imaginaryHeight;

        double dx = (realEnd - realStart) / canvas.getWidth();
        double dy = (imaginaryEnd - imaginaryStart) / canvas.getHeight();

        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                double cReal = realStart + x * dx;
                double cImaginary = imaginaryStart + y * dy;
                double zReal = 0;
                double zImaginary = 0;
                int iterations = 0;

                while (zReal * zReal + zImaginary * zImaginary < 4 && iterations < 100) {
                    double zRealTemp = zReal * zReal - zImaginary * zImaginary + cReal;
                    zImaginary = 2 * zReal * zImaginary + cImaginary;
                    zReal = zRealTemp;
                    iterations++;
                }

                if (iterations == 100) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.hsb(360 * (iterations / 100.0), 1, 1));
                }
                gc.fillRect(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}