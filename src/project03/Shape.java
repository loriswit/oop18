// Loris Witschard & Nicolas Bovet
package project03;

import oop.lib.Paintable;
import oop.lib.Painting;

import java.awt.*;

public abstract class Shape implements Paintable
{
    private Point center;
    private Color color;
    
    public Shape(Point center, Color color)
    {
        this.center = center;
        this.color = color;
    }
    
    public void translate(Point vector)
    {
        center.translate(vector.x(), vector.y());
    }
    
    public void rotate(double angle, Point origin)
    {
        center.rotate(angle, origin);
    }
    
    public Point getCenter()
    {
        return center;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public abstract void scale(double scalar);
    
    public abstract double getArea();
    
    @Override
    public void paint(Painting painting)
    {
        painting.setColor(getColor());
    }
}
