// Loris Witschard & Nicolas Bovet
package project11.transform;

import oop.lib.Degrees;
import project11.View;
import project11.gfx.Point;
import project11.gfx.shape.Shape;

public class Rotator extends Transformer
{
    private double prevAngle;
    
    public Rotator(View view, Shape shape, Point point)
    {
        super(view, shape);
        
        Point centroid = shape.centroid();
        prevAngle = computeAngle(point, centroid);
    }
    
    @Override
    public void controlMoved(Point point)
    {
        Point centroid = shape.centroid();
        double angle = prevAngle - computeAngle(point, centroid);
        
        angle = View.STEP_ANGLE * Math.round(angle / View.STEP_ANGLE);
        shape.rotate(angle);
        prevAngle -= angle;
    }
    
    private static double computeAngle(Point pt1, Point pt2)
    {
        return Degrees.atan2(pt2.x() - pt1.x(), pt2.y() - pt1.y());
    }
}
