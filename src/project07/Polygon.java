package project07;

import java.awt.Color;

import oop.lib.Painting;



public class Polygon extends Shape {

    private Point[] points;

    public Polygon(Point center, Color color, Point[] points) {
        super(center, color);
        this.points = points;
        translate(-centroid().x()+center.x(),-centroid().y()+center.y());
    }

    public Polygon(Color color, Point[] points) {
        super(color);
        this.points = points;
        System.out.println(centroid().y());

        translate(-centroid().x(),-centroid().y());
    }

    public double area() {
        double sum = 0;
        for (int i = 0; i < points.length; i++) {
            sum += (points[i].x() * points[(i + 1) % points.length].y())
                    - (points[(i + 1) % points.length].x() * points[i].y());
        }
        return Math.abs(sum / 2);
    }

    public final Point centroid() {
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < points.length; i++) {
            double aux = (points[i].x() * points[(i + 1) % points.length].y())
                    - (points[(i + 1) % points.length].x() * points[i].y());
            sumX += (points[i].x() + points[(i + 1) % points.length].x()) * aux;
            sumY += (points[i].y() + points[(i + 1) % points.length].y()) * aux;
        }

        return new Point(sumX / (6 * area()), sumY / (6 * area()));
    }

    public void translate(double dx, double dy) {
        for (Point vertex : points) {
            vertex.translate(dx, dy);
        }
    }


    public void rotate(double angle, Point anchor) {
        for (Point pt : points) {
            pt.rotate(angle, anchor);
        }
    }

    public void scale(double factor, Point anchor) {
        for (Point pt : points) {
            pt.scale(factor, anchor);
        }
    }

    public double getArea() {
        return area();
    }

    public double[][] pointsAsArrays() {
        double[][] array = new double[points.length][];
        for (int i = 0; i < points.length; i++) {
            array[i] = points[i].asArray();
        }
        return array;
    }

    @Override
    public boolean contains(Point pt) {
        Point pt2 = new Point(-999, 999);
        Segment sgt1 = new Segment(pt,pt2);
        boolean intersections = false;

        for (int i = 0 ; i < points.length ; i++){
            if(Segment.intersection(sgt1,new Segment(points[i],points[(i+1) % points.length])))
                intersections = !intersections;
        }
        return intersections;
    }

    public void paint(Painting display) {
        super.paint(display);
        display.fillPolygon(pointsAsArrays()); 
    }
}
