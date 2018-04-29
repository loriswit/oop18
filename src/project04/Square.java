// Loris Witschard & Nicolas Bovet
package project04;

import java.awt.Color;

import oop.lib.Painting;

public class Square extends Shape
{
    private double side;
    private double angle = 0;
    
    public Square(Point center, double side, Color color)
    {
        super(center, color);
        this.side = side;
    }
    
    public Square(Point center, double side)
    {
        this(center, side, Color.RED);
    }
    
    @Override
    public void scale(double scalar)
    {
        side *= scalar;
    }
    
    @Override
    public void rotate(double angle, Point origin)
    {
        this.angle += angle;
        super.rotate(angle, origin);
    }
    
    public double getSide()
    {
        return side;
    }
    
    @Override
    public double getArea()
    {
        return side * side;
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
        display.fillSquare(getCenter().asArray(), side, angle);
    }
}
