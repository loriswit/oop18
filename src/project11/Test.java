// Loris Witschard & Nicolas Bovet
package project11;

import project11.gfx.Point;
import project11.gfx.Vector;
import project11.gfx.shape.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Test implements Runnable
{
    private static final int BIG_TRIANGLE_1 = 0;
    private static final int BIG_TRIANGLE_2 = 1;
    private static final int AVERAGE_TRIANGLE = 2;
    private static final int SQUARE = 3;
    private static final int PARALLELOGRAM = 4;
    private static final int SMALL_TRIANGLE_1 = 5;
    private static final int SMALL_TRIANGLE_2 = 6;
    
    private static final Point origin = new Point(0, 0);
    
    private static Tan[] tans = new Tan[7];
    private static Vector[] offsets = new Vector[7];
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Test());
    }
    
    @Override
    public void run()
    {
        tans[SMALL_TRIANGLE_1] = new Tan(new Triangle(origin, 1, 1, 0.5, Color.BLUE));
        offsets[SMALL_TRIANGLE_1] = new Vector(-Math.sqrt(2) / 2, Math.sqrt(2) * 5 / 6);
        
        tans[SMALL_TRIANGLE_2] = new Tan(new Triangle(origin, 1, 1, 0.5, Color.ORANGE));
        offsets[SMALL_TRIANGLE_2] = new Vector(Math.sqrt(2) * 2 / 6, 0);
        
        tans[AVERAGE_TRIANGLE] = new Tan(new Triangle(origin, Math.sqrt(2), Math.sqrt(2), Math.sqrt(2) / 2, Color.GREEN));
        offsets[AVERAGE_TRIANGLE] = new Vector(Math.sqrt(8.0 / 9), Math.sqrt(8.0 / 9));
        
        tans[BIG_TRIANGLE_1] = new Tan(new Triangle(origin, 2, 2, 1, Color.YELLOW));
        offsets[BIG_TRIANGLE_1] = new Vector(-Math.sqrt(2) * 2 / 3, 0);
        
        tans[BIG_TRIANGLE_2] = new Tan(new Triangle(origin, 2, 2, 1, Color.RED));
        offsets[BIG_TRIANGLE_2] = new Vector(0, -Math.sqrt(2) * 2 / 3);
        
        tans[SQUARE] = new Tan(new Square(origin, 1, Color.CYAN));
        offsets[SQUARE] = new Vector(0, 1.0 / Math.sqrt(2));
        
        tans[PARALLELOGRAM] = new Tan(new Parallelogram(origin, 1, 1, -1, Color.MAGENTA));
        offsets[PARALLELOGRAM] = new Vector(3.0 / 2 / Math.sqrt(2), -1.0 / 2 / Math.sqrt(2));
        
        for(int i = 0; i < tans.length; ++i)
        {
            tans[i].translate(offsets[i].dx(), offsets[i].dy());
            tans[i].translate(rand() * View.STEP_SIZE, rand() * View.STEP_SIZE);
            tans[i].rotate(rand() * View.STEP_ANGLE);
            tans[i].scale(0.999);
        }
        
        Window window = new Window();
        window.getView().add(tans);
    }
    
    private int rand()
    {
        return ThreadLocalRandom.current().nextInt(-12, 12);
    }
}
