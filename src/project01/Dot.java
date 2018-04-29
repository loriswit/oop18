// Loris Witschard & Nicolas Bovet
package project01;

import java.awt.Color;

import oop.lib.Paintable;
import oop.lib.Painting;

public class Dot implements Paintable
{
    public static final double RADIUS = 5;
    
    private Color color = Color.RED;
    private Point point;
    
    public Dot(Point center)
    {
        point = center;
    }
    
    public Dot(Point center, Color color)
    {
        this.color = color;
        point = center;
    }
    
    public Point getCenter()
    {
        return point;
    }
    
    @Override
    public void paint(Painting display)
    {
        display.setColor(color);
        display.fillCircle(point.asArray(), RADIUS);
    }
    
}
