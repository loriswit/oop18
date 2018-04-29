// Loris Witschard & Nicolas Bovet
package project04;

import oop.project.Bench;

public class Test extends Bench
{
    public static void main(String[] args)
    {
        new Test();
    }
    
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 450;
    private static final double SCENE_SCALE = 10;
    
    private Point center1 = new Point(-30, 0);
    private Point center2 = new Point(-15, 0);
    private Point center3 = new Point(0, 0);
    
    private Polygon polygon1 = new Polygon(center1,
        new Point[]{new Point(-4, 0), new Point(0, -6), new Point(4, 0)});
    private Polygon polygon2 = new Polygon(center2,
        new Point[]{new Point(-2, -2), new Point(-3, 8), new Point(4, 3), new Point(5, 0)});
    private Polygon polygon3 = new Polygon(center3,
        new Point[]{new Point(-6, 0), new Point(-2, 7)});
    private Polygon duplicate = polygon3.duplicate();
    
    public Test()
    {
        super(SCENE_WIDTH, SCENE_HEIGHT);
    }
    
    @Override
    public void init()
    {
        defineCoordinates(SCENE_WIDTH / 2, SCENE_HEIGHT / 2, SCENE_SCALE, false);
        
        add(polygon1);
        add(polygon2);
        add(polygon3);
        add(duplicate);
    }
    
    @Override
    public void step()
    {
        polygon3.rotate(5, polygon3.getCenter());
        duplicate.rotate(-5, duplicate.getCenter());
    }
}

