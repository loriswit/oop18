// Loris Witschard & Nicolas Bovet
package project01;

import oop.project.Bench;

import java.awt.*;

public class Test extends Bench
{
    public static void main(String[] args)
    {
        new Test();
    }
    
    private Point origin = new Point(50, 200);
    private Point point = new Point(100, 200);
    
    @Override
    public void init()
    {
        add(new Dot(origin, Color.BLACK));
        add(new Dot(point, Color.BLUE));
    }
    
    @Override
    public void step()
    {
        final Point vector = new Point(5, 0);
        
        point.rotate(origin, 20);
        point.translate(vector);
        origin.translate(vector);
    }
    
}
