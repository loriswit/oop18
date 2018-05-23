// Loris Witschard & Nicolas Bovet
package project11.gfx;

import project11.gfx.shape.Polygon;

public interface Properties
{
    double area();
    
    Point centroid();
    
    boolean contains(Point point);
}
