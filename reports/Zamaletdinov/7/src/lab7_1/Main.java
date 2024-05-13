package org.example.lab7_1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);

        Rectangle rect = new Rectangle(0, 0, 200, 15);
        rect.setTranslateX(250);
        rect.setTranslateY(250);
        rect.setFill(Color.BLACK);

        root.getChildren().add(rect);

        final TextField widthField = new TextField("200");
        widthField.setTranslateX(20);
        widthField.setTranslateY(20);
        root.getChildren().add(widthField);

        final TextField heightField = new TextField("15");
        heightField.setTranslateX(20);
        heightField.setTranslateY(50);
        root.getChildren().add(heightField);

        Button applyButton = new Button("Apply");
        applyButton.setTranslateX(20);
        applyButton.setTranslateY(80);
        applyButton.setOnAction(event -> {
            try {
                double rectWidth = Double.parseDouble(widthField.getText());
                double rectHeight = Double.parseDouble(heightField.getText());
                rect.setWidth(rectWidth);
                rect.setHeight(rectHeight);

                scene.getRoot().requestFocus();
            } catch (NumberFormatException e) {
            }
        });
        root.getChildren().add(applyButton);

        final Rotate rotate = new Rotate();
        rect.getTransforms().add(rotate);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                stage.getScene().setOnKeyPressed(e -> {
                    rotate.setPivotX(rect.getX());
                    rotate.setPivotY(rect.getY());
                    if (e.getCode() == KeyCode.LEFT) {
                        rotate.setAngle(rotate.getAngle() - 5);
                    } else if (e.getCode() == KeyCode.RIGHT){
                        rotate.setAngle(rotate.getAngle() + 5);
                    }
                });
            }
        };
        timer.start();

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

