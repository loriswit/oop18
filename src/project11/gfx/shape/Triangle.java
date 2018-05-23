// Loris Witschard & Nicolas Bovet
package project11.gfx.shape;

import project11.gfx.Point;
import project11.gfx.Vector;

import java.awt.*;

public class Triangle extends Polygon
{
    public Triangle(Point center, double width, double height, double offset, Color color)
    {
        super(toPath(width, height, offset), color, center);
    }
    
    private static Vector[] toPath(double width, double height, double offset)
    {
        return new Vector[]{
            new Vector(width, 0),
            new Vector(-width / 2 + offset, height)
        };
    }
}
