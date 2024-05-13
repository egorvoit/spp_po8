package org.example.task1;

public class Point {
    private int X;
    private int Y;

    public Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Точка{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}