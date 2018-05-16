// Loris Witschard & Nicolas Bovet
package project09;

import oop.lib.Display;
import project09.gfx.shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View extends Display
{
    private List<Shape> shapes = new ArrayList<>();
    
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 400;
    private static final double SCENE_SCALE = 120;
    
    public View()
    {
        setOrigin(SCENE_WIDTH / 2, SCENE_HEIGHT / 2);
        setScale(SCENE_SCALE, false);
        
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(SCENE_WIDTH, SCENE_HEIGHT));
    }
    
    public void add(Shape... shapes)
    {
        this.shapes.addAll(Arrays.asList(shapes));
    }
    
    @Override
    public void paint(Display display)
    {
        for(Shape shape : shapes)
            shape.paint(display);
    }
}
