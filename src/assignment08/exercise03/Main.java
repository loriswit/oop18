// Loris Witschard & Nicolas Bovet
package assignment08.exercise03;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        foo();
        
        try
        {
            bar();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    static private void foo()
    {
        throw new IllegalStateException();
    }
    
    static private void bar() throws IOException
    {
        throw new IOException();
    }
}
