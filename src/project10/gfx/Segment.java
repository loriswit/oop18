// Loris Witschard & Nicolas Bovet
package project10.gfx;

public class Segment
{
    private Point pt1;
    private Point pt2;
    
    public Segment(Point pt1, Point pt2)
    {
        this.pt1 = pt1;
        this.pt2 = pt2;
    }
    
    public boolean intersects(Segment other)
    {
        double sgt1rot1 = ccw(other.pt1);
        double sgt1rot2 = ccw(other.pt2);
        double sgt2rot1 = other.ccw(pt1);
        double sgt2rot2 = other.ccw(pt2);
        
        return sgt2rot1 * sgt2rot2 < 0 && sgt1rot1 * sgt1rot2 < 0;
    }
    
    private double ccw(Point point)
    {
        return (pt2.x() - pt1.x()) * (point.y() - pt1.y()) - (pt2.y() - pt1.y()) * (point.x() - pt1.x());
    }
}
