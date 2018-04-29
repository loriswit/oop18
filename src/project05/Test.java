// Loris Witschard & Nicolas Bovet
package project05;

import java.awt.Color;
import java.util.Arrays;

import oop.project.Bench;

public class Test extends Bench
{
    public static void main(String[] args)
    {
        new Test();
    }
    
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 400;
    private static final double SCENE_SCALE = 120;
    
    private Shape[] shapes = new Shape[7];
    private Vector[] offsets = new Vector[7];
    private double[] angles = new double[7];
    
    private static final int BIG_TRIANGLE_1 = 0;
    private static final int BIG_TRIANGLE_2 = 1;
    private static final int AVERAGE_TRIANGLE = 2;
    private static final int SQUARE = 3;
    private static final int PARALLELOGRAM = 4;
    private static final int SMALL_TRIANGLE_1 = 5;
    private static final int SMALL_TRIANGLE_2 = 6;
    
    private static final Point origin = new Point(0, 0);
    
    @Override
    public void init()
    {
        defineCoordinates(SCENE_WIDTH / 2, SCENE_HEIGHT / 2, SCENE_SCALE, false);
        
        shapes[SMALL_TRIANGLE_1] = new Triangle(origin, 1, 1, 0.5, Color.BLUE);
        offsets[SMALL_TRIANGLE_1] = new Vector(-Math.sqrt(2) / 2, Math.sqrt(2) * 5 / 6);
        angles[SMALL_TRIANGLE_1] = -45;
        
        shapes[SMALL_TRIANGLE_2] = new Triangle(origin, 1, 1, 0.5, Color.ORANGE);
        offsets[SMALL_TRIANGLE_2] = new Vector(Math.sqrt(2) * 2 / 6, 0);
        angles[SMALL_TRIANGLE_2] = -135;
        
        shapes[AVERAGE_TRIANGLE] = new Triangle(origin, Math.sqrt(2), Math.sqrt(2), Math.sqrt(2) / 2, Color.GREEN);
        offsets[AVERAGE_TRIANGLE] = new Vector(Math.sqrt(8.0 / 9), Math.sqrt(8.0 / 9));
        angles[AVERAGE_TRIANGLE] = 90;
        
        shapes[BIG_TRIANGLE_1] = new Triangle(origin, 2, 2, 1, Color.YELLOW);
        offsets[BIG_TRIANGLE_1] = new Vector(-Math.sqrt(2) * 2 / 3, 0);
        angles[BIG_TRIANGLE_1] = 45;
        
        shapes[BIG_TRIANGLE_2] = new Triangle(origin, 2, 2, 1, Color.RED);
        offsets[BIG_TRIANGLE_2] = new Vector(0, -Math.sqrt(2) * 2 / 3);
        angles[BIG_TRIANGLE_2] = 135;
        
        shapes[SQUARE] = new Square(origin, 1, Color.CYAN);
        offsets[SQUARE] = new Vector(0, 1.0 / Math.sqrt(2));
        angles[SQUARE] = 45;
        
        shapes[PARALLELOGRAM] = new Parallelogram(origin, 1, 1, -1, Color.MAGENTA);
        offsets[PARALLELOGRAM] = new Vector(3.0 / 2 / Math.sqrt(2), -1.0 / 2 / Math.sqrt(2));
        angles[PARALLELOGRAM] = -45;
        
        add(new Square(origin, Math.sqrt(8), Color.BLACK));
        addAll(Arrays.asList(shapes));
    }
    
    private final static int MAX_STEP = 100;
    private int step = 0;
    
    @Override
    public void step()
    {
        if(step == MAX_STEP)
            return;
        
        for(int i = 0; i < shapes.length; ++i)
        {
            shapes[i].translate(offsets[i].dx() / MAX_STEP, offsets[i].dy() / MAX_STEP);
            shapes[i].rotate(angles[i] / MAX_STEP);
        }
        ++step;
    }
}
