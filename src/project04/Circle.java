// Loris Witschard & Nicolas Bovet
package project04;

import java.awt.Color;

import oop.lib.Painting;

public class Circle extends Shape
{
    private double radius;
    
    public Circle(Point center, double radius, Color color)
    {
        super(center, color);
        this.radius = radius;
    }
    
    public Circle(Point center, double radius)
    {
        this(center, radius, Color.RED);
    }
    
    @Override
    public void scale(double scalar)
    {
        radius *= scalar;
    }
    
    public double getRadius()
    {
        return radius;
    }
    
    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    
    @Override
    public Point getCentroid()
    {
        return getCenter();
    }
    
    @Override
    public void paint(Painting display)
    {
        super.paint(display);
        display.fillCircle(getCenter().asArray(), radius);
    }
}
