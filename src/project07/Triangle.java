package project07;

import java.awt.*;

public class Triangle extends Polygon {

    public Triangle(Point center, Color color, double base, double height, double offset) {
        super(center,color,pathTriangle(base,height,offset));
    }

    public Triangle(Color color, double base, double height, double offset) {
        super(color,pathTriangle(base,height,offset));
    }

    private static Point[] pathTriangle(double base, double height, double offset){

        Point[] points = new Point[3];

        points[2] = new Point(0,0);
        points[1] = new Point(base/2-offset,height);
        points[0] = new Point(base,0);
        System.out.println(points.length);
        return points;
    }

    public static double hypothenus(double side, double side2) {
        return Math.sqrt(Math.pow(side,2)+Math.pow(side2,2));
    }
}
