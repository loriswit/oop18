// Loris Witschard & Nicolas Bovet
package project04;

import oop.lib.Paintable;
import oop.lib.Painting;

import java.awt.*;

public abstract class Shape implements Paintable, Properties
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
    
    @Override
    public void paint(Painting display)
    {
        display.setColor(color);
    }
}
