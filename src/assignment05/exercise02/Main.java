// Loris Witschard & Nicolas Bovet
package assignment05.exercise02;

import java.awt.*;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Point> pointStack = new Stack<>();
        
        for(int i = 0; i < 157; ++i)
            integerStack.push(randomNumber(999));
        
        for(int i = 0; i < 157; i++)
            pointStack.push(new Point(randomNumber(999), randomNumber(999)));

        integerStack.printElements();
        pointStack.printElements();
    }
    
    private static Random random = new Random();
    
    public static int randomNumber(int max)
    {
        return random.nextInt(max);
    }
}
