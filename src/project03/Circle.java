// Loris Witschard & Nicolas Bovet
package project03;

import oop.lib.Painting;

import java.awt.*;

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
    
    public double getRadius()
    {
        return radius;
    }
    
    @Override
    public void scale(double scalar)
    {
        radius *= scalar;
    }
    
    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void paint(Painting painting)
    {
        super.paint(painting);
        painting.fillCircle(getCenter().asArray(), radius);
    }
}
