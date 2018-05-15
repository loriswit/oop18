// Loris Witschard & Nicolas Bovet
package project10;

import project10.gfx.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter implements KeyListener
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
        var x = (e.getX() - view.getXOrigin()) / view.getXScale();
        var y = (e.getY() - view.getYOrigin()) / view.getYScale();
        
        selection = new Selection(view, new Point(x, y));
        view.repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    
    private static final double DISTANCE = 0.25;
    private static final double ANGLE = 15;
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(selection == null)
            return;
        
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                selection.translate(-DISTANCE, 0);
                break;
            case KeyEvent.VK_RIGHT:
                selection.translate(DISTANCE, 0);
                break;
            case KeyEvent.VK_UP:
                selection.translate(0, -DISTANCE);
                break;
            case KeyEvent.VK_DOWN:
                selection.translate(0, DISTANCE);
                break;
            
            case KeyEvent.VK_R:
                selection.rotate(ANGLE);
        }
        
        view.repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
