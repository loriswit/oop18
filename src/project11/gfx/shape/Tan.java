// Loris Witschard & Nicolas Bovet
package project11.gfx.shape;

import project11.gfx.Point;

import java.awt.*;

public class Tan extends Group
{
    private Polygon polygon;
    private Circle spot;
    
    public Tan(Polygon polygon)
    {
        super(polygon);
        this.polygon = polygon;
    
        spot = new Circle(polygon.centroid(), 0.1, Color.BLACK);
        add(spot);
    }
    
    public boolean isOnSpot(Point point)
    {
        return spot.contains(point);
    }
    
    public Polygon polygon()
    {
        return polygon;
    }
}
