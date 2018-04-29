// Loris Witschard & Nicolas Bovet
package project02;

import java.awt.Color;

import oop.lib.Paintable;
import oop.lib.Painting;

public class Square implements Paintable
{
    private Point center;
    private double side;
    private Color color;
    private double angle = 0;
    
    public Square(Point center, double side, Color color)
    {
        this.center = center;
        this.side = side;
        this.color = color;
    }
    
    public Square(Point center, double side)
    {
        this(center, side, Color.RED);
    }
    
    public void translate(Point vector)
    {
        center.translate(vector.x(), vector.y());
    }
    
    public void scale(double scalar)
    {
        side *= scalar;
    }
    
    public void rotate(double angle, Point origin)
    {
        this.angle += angle;
        center.rotate(angle, origin);
    }
    
    public double getSide()
    {
        return side;
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
        return side * side;
    }
    
    @Override
    public void paint(Painting display)
    {
        display.setColor(color);
        display.fillSquare(center.asArray(), side, angle);
    }
}
