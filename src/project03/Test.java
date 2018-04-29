// Loris Witschard & Nicolas Bovet
package project03;

import oop.project.Bench;

import java.awt.*;

public class Test extends Bench
{
    public static void main(String[] args)
    {
        new Test();
    }
    
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 450;
    private static final double SCENE_SCALE = 10;
    
    private Point squareCenter = new Point(-40, 0);
    private Point circleCenter = new Point(-30, 0);
    
    private Square square = new Square(squareCenter, 5, Color.BLUE);
    private Circle circle = new Circle(circleCenter, 1, Color.BLACK);
    
    private final Point shapeSpeed = new Point(0.2, 0);
    
    private int counter = 0;
    
    public Test()
    {
        super(SCENE_WIDTH, SCENE_HEIGHT);
    }
    
    @Override
    public void init()
    {
        defineCoordinates(SCENE_WIDTH / 2, SCENE_HEIGHT / 2, SCENE_SCALE, false);
        
        add(square);
        add(circle);
    }
    
    @Override
    public void step()
    {
        square.rotate(5, circleCenter);
        circle.scale(1 + Math.sin(counter++ * 0.1) * 0.1);
        
        square.translate(shapeSpeed);
        circle.translate(shapeSpeed);
    }
}
