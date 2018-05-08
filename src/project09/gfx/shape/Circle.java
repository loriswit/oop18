// Loris Witschard & Nicolas Bovet
package project09.gfx.shape;

import oop.lib.Painting;
import project09.gfx.Point;

import java.awt.*;

public class Circle extends Shape
{
    private Point center;
    private double radius;
    
    public Circle(Point center, double radius, Color color)
    {
        super(color);
        this.center = center.duplicate();
        this.radius = radius;
    }
    
    @Override
    public void translate(double deltaX, double deltaY)
    {
        center.translate(deltaX, deltaY);
    }
    
    @Override
    public void rotate(double angle, Point anchor)
    {
        center.rotate(angle, anchor);
    }
    
    @Override
    public void scale(double factor, Point anchor)
    {
        center.scale(factor, anchor);
        radius *= factor;
    }
    
    @Override
    public void paint(Painting painting)
    {
        painting.setColor(getColor());
        painting.fillCircle(center.asArray(), radius);
    }
    
    @Override
    public double area()
    {
        return Math.PI * radius * radius;
    }
    
    @Override
    public Point centroid()
    {
        return center;
    }
}
