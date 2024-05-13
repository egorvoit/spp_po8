package org.example.lab7_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class task2 extends Application {

    private final int lx = 10, ly = 10;
    private int X = 50, Y = 50;
    TextField orderField;
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button drawButton = new Button("Draw");
        orderField = new TextField("1");
        orderField.setPromptText("Введите порядок кривой Гильберта:");

        drawButton.setOnAction(e -> draw(gc, orderField.getText()));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Введите порядок кривой Гильберта:"), 0, 0);
        grid.add(orderField, 1, 0);
        grid.add(drawButton, 1, 1);

        StackPane root = new StackPane(canvas, grid);
        StackPane.setAlignment(grid, Pos.TOP_CENTER);

        Scene scene = new Scene(root, 800, 800);

        primaryStage.setTitle("Hilbert Curve");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void draw(GraphicsContext gc, String input) {
        try {
            gc.clearRect(0, 0, 800, 800);
            int order = Integer.parseInt(input);
//            int initialX = 50;
//            int initialY = 50;
            X = 50;
            Y = 50;
            a(order, gc);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please enter a valid integer value.");
            alert.showAndWait();
            orderField.clear();
        }
    }

    private void drawPart(GraphicsContext gc, int lx, int ly) {
        gc.setStroke(Color.VIOLET);
        gc.strokeLine(X, Y, X + lx, Y + ly);
        X += lx;
        Y += ly;
    }

    private void a(int i, GraphicsContext gc) {
        if (i > 0) {
            d(i - 1, gc);
            drawPart(gc, lx, 0);
            a(i - 1, gc);
            drawPart(gc, 0, ly);
            a(i - 1, gc);
            drawPart(gc, -lx, 0);
            c(i - 1, gc);
        }
    }

    private void b(int i, GraphicsContext gc) {
        if (i > 0) {
            c(i - 1, gc);
            drawPart(gc, -lx, 0);
            b(i - 1, gc);
            drawPart(gc, 0, -ly);
            b(i - 1, gc);
            drawPart(gc, lx, 0);
            d(i - 1, gc);
        }
    }

    private void c(int i, GraphicsContext gc) {
        if (i > 0) {
            b(i - 1, gc);
            drawPart(gc, 0, -ly);
            c(i - 1, gc);
            drawPart(gc, -lx, 0);
            c(i - 1, gc);
            drawPart(gc, 0, ly);
            a(i - 1, gc);
        }
    }

    private void d(int i, GraphicsContext gc) {
        if (i > 0) {
            a(i - 1, gc);
            drawPart(gc, 0, ly);
            d(i - 1, gc);
            drawPart(gc, lx, 0);
            d(i - 1, gc);
            drawPart(gc, 0, -ly);
            b(i - 1, gc);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}