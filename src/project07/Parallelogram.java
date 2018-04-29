package project07;

import java.awt.*;

public class Parallelogram extends Polygon {

    public Parallelogram(Point center, Color color, double side, double height, double offset) {
        super(center,color,pathParallelogram(side,height,offset));
    }

    public Parallelogram(Color color, double side, double height, double offset) {
        super(color,pathParallelogram(side,height,offset));
    }

    private static Point[] pathParallelogram(double side,double heigt, double offset) {
        Point[] points = new Point[4];

        points[3] = new Point(0,0);
        points[2] = new Point(-offset,heigt);
        points[1] = new Point(side-offset,heigt);
        points[0] = new Point(side,0);

        return points;
    }
}
