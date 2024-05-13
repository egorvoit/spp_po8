package org.example.task1;

public class Triangle {
    private final Point[] vertices;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        vertices = new Point[] { pointA, pointB, pointC };
    }

    public boolean isPointInside(Point pointO) {
        Point pointA = vertices[0], pointB = vertices[1], pointC = vertices[2];

        int OAx = pointA.getX() - pointO.getX();
        int OAy = pointA.getY() - pointO.getY();
        int OBx = pointB.getX() - pointO.getX();
        int OBy = pointB.getY() - pointO.getY();
        int OCx = pointC.getX() - pointO.getX();
        int OCy = pointC.getY() - pointO.getY();
        int ABx = pointB.getX() - pointA.getX();
        int ABy = pointB.getY() - pointA.getY();
        int BCx = pointC.getX() - pointB.getX();
        int BCy = pointC.getY() - pointB.getY();
        int CAx = pointA.getX() - pointC.getX();
        int CAy = pointA.getY() - pointC.getY();

        int OAxAB = OAx * ABy - OAy * ABx;
        int OBxBC = OBx * BCy - OBy * BCx;
        int OCxCA = OCx * CAy - OCy * CAx;

        return (OAxAB <= 0 && OBxBC <= 0 && OCxCA <= 0)
                || (OAxAB >= 0 && OBxBC >= 0 && OCxCA >= 0);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Треугольник{" +
                "вершины=" + java.util.Arrays.toString(vertices) +
                '}';
    }

    public Point[] getVertices() {
        return vertices;
    }
}
