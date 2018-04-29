// Loris Witschard & Nicolas Bovet
package assignment07.exercise02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main
{
    static int LIST_SIZE = 10000;
    static int ITERATIONS = 1000000;
    
    public static void main(String[] args)
    {
        List<Integer> arrayList = new ArrayList<>(LIST_SIZE);
        List<Integer> linkedList = new LinkedList<>();
        
        for(int i = 0; i < LIST_SIZE; ++i)
        {
            arrayList.add(ThreadLocalRandom.current().nextInt());
            linkedList.add(ThreadLocalRandom.current().nextInt());
        }
        
        runIntegration(arrayList);
        runIntegration(linkedList);
    }
    
    static void runIntegration(List<Integer> list)
    {
        long startTime = System.nanoTime();
        
        int sum = 0;
        for(int i = 0; i < ITERATIONS; ++i)
            sum += list.get(ThreadLocalRandom.current().nextInt(LIST_SIZE));
        
        double elapsedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        
        System.out.println(list.getClass().getSimpleName() + ":");
        System.out.println("  Result = " + sum);
        System.out.println("  Elapsed time = " + String.format("%.3f", elapsedTime) + " sec");
        System.out.println();
    }
}
