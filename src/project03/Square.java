// Loris Witschard & Nicolas Bovet
package project03;

import oop.lib.Painting;

import java.awt.*;

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
    
    public double getSide()
    {
        return side;
    }
    
    @Override
    public void rotate(double angle, Point origin)
    {
        super.rotate(angle, origin);
        this.angle += angle;
    }
    
    @Override
    public void scale(double scalar)
    {
        side *= scalar;
    }
    
    @Override
    public double getArea()
    {
        return side * side;
    }
    
    @Override
    public void paint(Painting painting)
    {
        super.paint(painting);
        painting.fillSquare(getCenter().asArray(), side, angle);
    }
}
