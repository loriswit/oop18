// Loris Witschard & Nicolas Bovet
package project11;

import project11.gfx.Point;
import project11.transform.Selection;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter
{
    private Selection selection = null;
    private View view;
    
    public Controller(View view)
    {
        this.view = view;
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        selection = new Selection(view, getMousePoint(e));
        view.update();
    }
    
    @Override
    public void mouseDragged(MouseEvent e)
    {
        if(selection != null)
            selection.controlMoved(getMousePoint(e));
        
        view.update();
    }
    
    private Point getMousePoint(MouseEvent e)
    {
        double x = (e.getX() - view.getXOrigin()) / view.getXScale();
        double y = (e.getY() - view.getYOrigin()) / view.getYScale();
        return new Point(x, y);
    }
}
