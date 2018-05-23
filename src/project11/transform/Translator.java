// Loris Witschard & Nicolas Bovet
package project11.transform;

import project11.View;
import project11.gfx.Point;
import project11.gfx.shape.Shape;

public class Translator extends Transformer
{
    private Point prevPoint;
    
    public Translator(View view, Shape shape, Point point)
    {
        super(view, shape);
        prevPoint = point;
    }
    
    @Override
    public void controlMoved(Point point)
    {
        double dx = point.x() - prevPoint.x();
        double dy = point.y() - prevPoint.y();
    
        dx = View.STEP_SIZE * Math.round(dx / View.STEP_SIZE);
        dy = View.STEP_SIZE * Math.round(dy / View.STEP_SIZE);
        
        shape.translate(dx, dy);
        prevPoint.translate(dx, dy);
    }
}
