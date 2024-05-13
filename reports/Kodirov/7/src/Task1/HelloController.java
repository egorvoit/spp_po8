package org.example.task1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.util.List;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button add_point_button;

    @FXML
    private Button add_traingle_button;

    @FXML
    private Button remove_point_button;

    @FXML
    private Button remove_triangle_button;

    @FXML
    private Button checkPointsPosition_button;

    @FXML
    private Pane canvas;

    @FXML
    private TextField pointAX_text;

    @FXML
    private TextField pointAY_text;

    @FXML
    private TextField pointBX_text;

    @FXML
    private TextField pointBY_text;

    @FXML
    private TextField pointCX_text;

    @FXML
    private TextField pointCY_text;

    @FXML
    private TextField pointOX_text;

    @FXML
    private TextField pointOY_text;

    List<Point> points = new ArrayList<>();
    List<Triangle> triangles = new ArrayList<>();

    @FXML
    private ComboBox<String> points_comboBox;

    @FXML
    private ComboBox<String> triangles_comboBox;

    @FXML
    void addPoint(ActionEvent event) {
        Point pointO = new Point(Integer.parseInt(pointOX_text.getText()), Integer.parseInt(pointOY_text.getText()));

        points.add(pointO);
        points_comboBox.getItems().add(pointO.toString());

        redrawCanvas();
    }

    @FXML
    void addTriangle(ActionEvent event) {
        Point pointA = new Point(Integer.parseInt(pointAX_text.getText()), Integer.parseInt(pointAY_text.getText()));
        Point pointB = new Point(Integer.parseInt(pointBX_text.getText()), Integer.parseInt(pointBY_text.getText()));
        Point pointC = new Point(Integer.parseInt(pointCX_text.getText()), Integer.parseInt(pointCY_text.getText()));

        Triangle triangle = new Triangle(pointA, pointB, pointC);

        triangles.add(triangle);
        triangles_comboBox.getItems().add(triangle.toString());

        redrawCanvas();
    }

    @FXML
    void removePoint(ActionEvent event) {
        int selectedIndex = points_comboBox.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            Point selectedPoint = points.get(selectedIndex);
            points_comboBox.getItems().remove(selectedIndex);
            points.remove(selectedPoint);
        }
        redrawCanvas();
    }

    @FXML
    void removeTriangle(ActionEvent event) {
        int selectedIndex = triangles_comboBox.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            Triangle selectedTriangle = triangles.get(selectedIndex);
            triangles_comboBox.getItems().remove(selectedIndex);
            triangles.remove(selectedTriangle);
        }
        redrawCanvas();
    }

    private Polygon createTrianglePolygon(Triangle triangle) {
        Polygon trianglePolygon = new Polygon(
                triangle.getVertices()[0].getX(), triangle.getVertices()[0].getY(),
                triangle.getVertices()[1].getX(), triangle.getVertices()[1].getY(),
                triangle.getVertices()[2].getX(), triangle.getVertices()[2].getY()
        );
        trianglePolygon.setFill(Color.TRANSPARENT);
        trianglePolygon.setStroke(Color.BLACK);
        return trianglePolygon;
    }

    private void redrawCanvas() {
        canvas.getChildren().clear();
        for (Triangle triangle : triangles) {
            canvas.getChildren().add(createTrianglePolygon(triangle));
            Circle circlePointA = new Circle(triangle.getVertices()[0].getX(), triangle.getVertices()[0].getY(), 3);
            circlePointA.setFill(Color.ORANGE);
            Circle circlePointB = new Circle(triangle.getVertices()[1].getX(), triangle.getVertices()[1].getY(), 3);
            circlePointB.setFill(Color.ORANGE);
            Circle circlePointC = new Circle(triangle.getVertices()[2].getX(), triangle.getVertices()[2].getY(), 3);
            circlePointC.setFill(Color.ORANGE);

            canvas.getChildren().addAll(circlePointA, circlePointB, circlePointC);
        }

        checkPointsPosition();
    }

    @FXML
    void onClickCheckPositions(ActionEvent event) {
        checkPointsPosition();
    }

    void checkPointsPosition() {
        for (Point point : points) {
            Circle circlePoint = new Circle(point.getX(), point.getY(), 3);
            int selectedIndex = triangles_comboBox.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                Triangle selectedTriangle = triangles.get(selectedIndex);
                if (selectedTriangle.isPointInside(point)) {
                    circlePoint.setFill(Color.GREEN);
                }
                else {
                    circlePoint.setFill(Color.RED);
                }
            }
            else {
                circlePoint.setFill(Color.BLUE);
            }
            canvas.getChildren().add(circlePoint);
        }
    }
}
