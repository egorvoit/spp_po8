package org.example.lab7_2;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class task1 extends Application {

    private String characters;
    private int currentIndex = 0;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);

        Text centerText = new Text();
        root.getChildren().add(centerText);

        TextField textField = new TextField();
        textField.setPromptText("Enter characters");
        Button startButton = new Button("Start Animation");

        VBox inputBox = new VBox(10);
        inputBox.getChildren().addAll(textField, startButton);
        inputBox.setLayoutX((scene.getWidth() - 150) / 2);
        inputBox.setLayoutY(20);

        root.getChildren().add(inputBox);

        startButton.setOnAction(event -> {
            if (!textField.getText().isEmpty()){
                characters = textField.getText().toUpperCase();
            }
            currentIndex = 0;
            centerText.setText("");

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                if (currentIndex >= characters.length()) {
                    currentIndex = 0;
                }

                Text cornerText = new Text(Character.toString(characters.charAt(currentIndex++)));
                root.getChildren().add(cornerText);

                double x = Math.random() < 0.5 ? 0 : scene.getWidth();
                double y = Math.random() < 0.5 ? 0 : scene.getHeight();

                cornerText.setX(x);
                cornerText.setY(y);

                PathTransition transition = new PathTransition(Duration.seconds(1), new Line(x, y, scene.getWidth() / 2, scene.getHeight() / 2), cornerText);
                transition.setOnFinished(e2 -> {
                    root.getChildren().remove(cornerText);
                    centerText.setText(centerText.getText() + cornerText.getText());

                    Bounds textBounds = centerText.getBoundsInLocal();
                    centerText.setX(scene.getWidth() / 2 - textBounds.getWidth() / 2);
                    centerText.setY(scene.getHeight() / 2 - textBounds.getHeight() / 2);
                });
                transition.play();
            }));

            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
