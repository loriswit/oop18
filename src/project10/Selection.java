// Loris Witschard & Nicolas Bovet
package project10;

import project10.gfx.Point;
import project10.gfx.shape.Shape;

public class Selection
{
    private Shape selectedShape = null;
    
    public Selection(View view, Point point)
    {
        for(var shape : view.shapes())
            if(shape.contains(point))
                selectedShape = shape;
        
        if(selectedShape != null)
        {
            view.shapes().remove(selectedShape);
            view.shapes().add(selectedShape);
        }
    }
    
    public void translate(double dx, double dy)
    {
        if(selectedShape != null)
            selectedShape.translate(dx, dy);
    }
    
    public void rotate(double angle)
    {
        if(selectedShape != null)
            selectedShape.rotate(angle);
    }
}
