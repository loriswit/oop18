// Loris Witschard & Nicolas Bovet
package project11;

import oop.lib.Display;
import project11.gfx.Point;
import project11.gfx.Segment;
import project11.gfx.shape.Square;
import project11.gfx.shape.Tan;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View extends Display
{
    private List<Tan> tans = new ArrayList<>();
    
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 600;
    private static final double SCENE_SCALE = 120;
    
    public static final double STEP_SIZE = 1.0 / 12;
    public static final double STEP_ANGLE = 15;
    
    private static final Square GOAL_SHAPE = new Square(new Point(0, 0), Math.sqrt(8), Color.BLACK);
    
    public View()
    {
        setOrigin(SCENE_WIDTH / 2, SCENE_HEIGHT / 2);
        setScale(SCENE_SCALE, false);
        
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(SCENE_WIDTH, SCENE_HEIGHT));
    }
    
    public void add(Tan... tans)
    {
        this.tans.addAll(Arrays.asList(tans));
    }
    
    public List<Tan> tans()
    {
        return tans;
    }
    
    public int getXOrigin()
    {
        return super.getXOrigin();
    }
    
    public int getYOrigin()
    {
        return super.getYOrigin();
    }
    
    public double getXScale()
    {
        return super.getXScale();
    }
    
    public double getYScale()
    {
        return super.getYScale();
    }
    
    public boolean tangramComplete()
    {
        return tansInside() && !tansOverlap();
    }
    
    public void update()
    {
        if(tangramComplete())
            setBackground(Color.BLACK);
        else
            setBackground(Color.GRAY);
        
        repaint();
    }
    
    @Override
    public void paint(Display display)
    {
        GOAL_SHAPE.paint(display);
        
        for(Tan tan : tans)
            tan.paint(display);
    }
    
    private boolean tansInside()
    {
        for(Tan tan : tans)
            if(!GOAL_SHAPE.contains(tan.polygon()))
                return false;
        
        return true;
    }
    
    private boolean tansOverlap()
    {
        for(Tan tan1 : tans)
            for(Tan tan2 : tans)
            {
                if(tan1 == tan2)
                    continue;
                
                if(tan2.contains(tan1.centroid()))
                    return true;
                
                Point[] vertices1 = tan1.polygon().vertices();
                Point[] vertices2 = tan2.polygon().vertices();
                
                for(int i = 0; i < vertices1.length; ++i)
                    for(int j = 0; j < vertices2.length; ++j)
                    {
                        Segment segment1 = new Segment(vertices1[i], vertices1[(i + 1) % vertices1.length]);
                        Segment segment2 = new Segment(vertices2[j], vertices2[(j + 1) % vertices2.length]);
                        if(segment1.intersects(segment2))
                            return true;
                    }
            }
        
        return false;
    }
}
