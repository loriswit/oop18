// Loris Witschard & Nicolas Bovet
package project08.gfx.shape;

import project08.gfx.Point;
import project08.gfx.Vector;

import java.awt.*;

public class Parallelogram extends Polygon
{
    public Parallelogram(Point center, double width, double height, double offset, Color color)
    {
        super(toPath(width, height, offset), color, center);
    }
    
    private static Vector[] toPath(double width, double height, double offset)
    {
        return new Vector[]{
            new Vector(width, 0),
            new Vector(offset, height),
            new Vector(-width, 0),
        };
    }
}
