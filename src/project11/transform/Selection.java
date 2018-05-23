// Loris Witschard & Nicolas Bovet
package project11.transform;

import project11.View;
import project11.gfx.Point;
import project11.gfx.shape.Tan;

public class Selection
{
    private Transformer transformer = null;
    
    public Selection(View view, Point point)
    {
        Tan selectedTan = null;
        for(Tan tan : view.tans())
            if(tan.contains(point))
                selectedTan = tan;
        
        if(selectedTan != null)
        {
            view.tans().remove(selectedTan);
            view.tans().add(selectedTan);
            
            if(selectedTan.isOnSpot(point))
                transformer = new Translator(view, selectedTan, point);
            else
                transformer = new Rotator(view, selectedTan, point);
        }
    }
    
    public void controlMoved(Point point)
    {
        if(transformer != null)
            transformer.controlMoved(point);
    }
}
