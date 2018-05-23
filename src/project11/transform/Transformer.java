// Loris Witschard & Nicolas Bovet
package project11.transform;

import project11.View;
import project11.gfx.Point;
import project11.gfx.shape.Shape;

public abstract class Transformer
{
    protected Shape shape;
    protected View view;
    
    public Transformer(View view, Shape shape)
    {
        this.shape = shape;
        this.view = view;
    }
    
    public abstract void controlMoved(Point point);
}
