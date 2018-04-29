// Loris Witschard & Nicolas Bovet
package project02;

import oop.project.Bench;

import java.awt.*;

public class Test extends Bench
{
    public static void main(String[] args)
    {
        new Test();
    }
    
    private Point squareCenter = new Point(0, 200);
    private Point circleCenter = new Point(100, 200);
    
    private Square square = new Square(squareCenter, 50, Color.BLUE);
    private Circle circle = new Circle(circleCenter, 10, Color.BLACK);
    
    private int counter = 0;
    
    @Override
    public void init()
    {
        add(square);
        add(circle);
    }
    
    @Override
    public void step()
    {
        square.rotate(5, circleCenter);
        circle.scale(1 + Math.sin(counter++ * 0.1) * 0.1);
        
        square.translate(new Point(2, 0));
        circle.translate(new Point(2, 0));
    }
    
}
