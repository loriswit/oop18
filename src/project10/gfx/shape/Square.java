// Loris Witschard & Nicolas Bovet
package project10.gfx.shape;

import project10.gfx.Point;
import project10.gfx.Vector;

import java.awt.*;

public class Square extends Polygon
{
    public Square(Point center, double side, Color color)
    {
        super(toPath(side), color, center);
    }
    
    private static Vector[] toPath(double side)
    {
        return new Vector[]{
            new Vector(-side, 0),
            new Vector(0, -side),
            new Vector(side, 0)
        };
    }
}
