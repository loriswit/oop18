package project07;

import java.awt.*;

public class Rectangle extends Polygon {

    public Rectangle(Color color, double width, double heigt) {
        super(color,pathRectangle(width,heigt));
    }

    public Rectangle(Point center, Color color,int width, int height) {
        super(center, color, pathRectangle(width,height));

    }

    private static Point[] pathRectangle(double width, double height){
        Point[] points = new Point[4];

        points[3] = new Point(0,0);
        points[2] = new Point(0,height);
        points[1] = new Point(width,height);
        points[0] = new Point(width,0);

        return points;
    }

}
