// Loris Witschard & Nicolas Bovet
package project07;

import java.awt.Color;

import oop.lib.Painting;

public class Circle extends Shape
{
    private double radius;
    
    public Circle(Point center, double radius, Color color)
    {
        super(center,color);
        this.radius = radius;
    }
    
    public Circle(Point center, double radius)
    {
        this(center, radius, Color.RED);
    }

    @Override
    public void translate(double dx, double dy) {
        centroid().translate(dx,dy);
    }

    @Override
    public void scale(double scalar, Point anchor)
    {
        centroid().scale(scalar,anchor);
        radius *= scalar;
    }
    
    public double getRadius()
    {
        return radius;
    }

    public void rotate(double angle, Point origin)
    {
        centroid().rotate(angle,origin);
    }

    @Override
    public Point centroid() {
        return getCenter();
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getArea()
    {
        return area();
    }

    @Override
    public boolean contains(Point pt) {

        if(pt.distance(centroid()) < getRadius())
            return true;
        else
            return false;
    }

    @Override
    public void paint(Painting display) {
        super.paint(display);
        display.fillCircle(getCenter().asArray(), radius);
    }
}
