import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Triangle extends JFrame {
    private int __windowX;
    private int __windowY;
    private Point[] points;
    public Triangle(int windowX, int windowY, Point[] _points) {
        super("triangle");
        setSize(windowX, windowY);
        setVisible(true);
        setResizable(false);
        __windowX = windowX;
        __windowY = windowY;
        points=_points;
    }
    public void paint(Graphics g) {
        g.fillRect(0, 0, __windowX, __windowY);
        g.setColor(Color.BLUE);
        g.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);
        g.drawLine(points[1].x, points[1].y, points[2].x, points[2].y);
        g.drawLine(points[2].x, points[2].y, points[0].x, points[0].y);
        g.setColor(Color.RED);
        for(int i=3;i<points.length;i++){
            g.fillRect(points[i].x, points[i].y, 5, 5);
        }
    }
    public void check(Point point){
        float l1=sign(point, points[0], points[1]);
        float l2=sign(point, points[1], points[2]);
        float l3=sign(point, points[2], points[0]);
        boolean hasNeg = (l1 < 0) || (l2 < 0) || (l3 < 0);
        boolean hasPos = (l1 > 0) || (l2 > 0) || (l3 > 0);
        if(!(hasNeg && hasPos)){
            System.out.println("triangle consist point ("+point.x+","+point.y+")");
        }
        else{
            System.out.println("triangle not consist point ("+point.x+","+point.y+")");
        }
    }
    public float sign(Point pt, Point p1, Point p2) {
        return (pt.x - p2.x) * (p1.y - p2.y) - (p1.x - p2.x) * (pt.y - p2.y);
    }
    public void run(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class task1{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width : ");
        int windowX = sc.nextInt();
        System.out.print("Enter height : ");
        int windowY = sc.nextInt();
        Point[] points = new Point[5];
        for(int i = 0; i < 5; i++){
            System.out.println("Enter point "+(i+1)+" : ");
            System.out.print("Enter x : ");
            int X = sc.nextInt();
            System.out.print("Enter y : ");
            int Y = sc.nextInt();
            points[i] = new Point(X, Y);
        }
        sc.close();
        Triangle app = new Triangle(windowX, windowY, points);
        app.check(points[3]);
        app.check(points[4]);
        app.run();
    }
}