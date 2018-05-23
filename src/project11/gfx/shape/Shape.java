// Loris Witschard & Nicolas Bovet
package project11.gfx.shape;

import oop.lib.Paintable;
import project11.gfx.Point;
import project11.gfx.Properties;

import java.awt.*;

public abstract class Shape implements Paintable, Properties
{
    private Color color;
    
    public Shape(Color color)
    {
        this.color = color;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public abstract void translate(double deltaX, double deltaY);
    
    public abstract void rotate(double angle, Point anchor);
    
    public final void rotate(double angle)
    {
        rotate(angle, centroid());
    }
    
    public abstract void scale(double factor, Point anchor);
    
    public final void scale(double factor)
    {
        scale(factor, centroid());
    }
    
    public boolean contains(Polygon polygon)
    {
        for(Point vertex : polygon.vertices())
            if(!contains(vertex))
                return false;
        
        return true;
    }
}
