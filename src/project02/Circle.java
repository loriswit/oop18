// Loris Witschard & Nicolas Bovet
package project02;

import java.awt.Color;

import oop.lib.Paintable;
import oop.lib.Painting;

public class Circle implements Paintable
{
    private Point center;
    private double radius;
    private Color color;
    
    public Circle(Point center, double radius, Color color)
    {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }
    
    public Circle(Point center, double radius)
    {
        this(center, radius, Color.RED);
    }
    
    public void translate(Point vector)
    {
        center.translate(vector.x(), vector.y());
    }
    
    public void scale(double scalar)
    {
        radius *= scalar;
    }
    
    public void rotate(double angle, Point origin)
    {
        center.rotate(angle, origin);
    }
    
    public double getRadius()
    {
        return radius;
    }
    
    public Point getCenter()
    {
        return center;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void paint(Painting display)
    {
        display.setColor(color);
        display.fillCircle(center.asArray(), radius);
    }
}
