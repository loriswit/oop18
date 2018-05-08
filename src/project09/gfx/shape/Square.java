// Loris Witschard & Nicolas Bovet
package project09.gfx.shape;

import oop.lib.Painting;
import project09.gfx.Point;

import java.awt.*;

public class Square extends Shape
{
    private Point center;
    private double side;
    private double angle = 0;
    
    public Square(Point center, double side, Color color)
    {
        super(color);
        this.center = center.duplicate();
        this.side = side;
    }
    
    @Override
    public void translate(double deltaX, double deltaY)
    {
        center.translate(deltaX, deltaY);
    }
    
    @Override
    public void rotate(double angle, Point anchor)
    {
        this.angle += angle;
        center.rotate(angle, anchor);
    }
    
    @Override
    public void scale(double factor, Point anchor)
    {
        side *= factor;
        center.scale(factor, anchor);
    }
    
    @Override
    public void paint(Painting painting)
    {
        painting.setColor(getColor());
        painting.fillSquare(center.asArray(), side, angle);
    }
    
    @Override
    public double area()
    {
        return side * side;
    }
    
    @Override
    public Point centroid()
    {
        return center;
    }
}
