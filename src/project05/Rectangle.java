// Loris Witschard & Nicolas Bovet
package project05;

import java.awt.*;

public class Rectangle extends Polygon
{
    public Rectangle(Point center, double width, double height, Color color)
    {
        super(toPath(width, height), color, center);
    }
    
    private static Vector[] toPath(double width, double height)
    {
        return new Vector[]{
            new Vector(width, 0),
            new Vector(0, height),
            new Vector(-width, 0),
        };
    }
}
