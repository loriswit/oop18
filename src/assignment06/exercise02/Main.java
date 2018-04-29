// Loris Witschard & Nicolas Bovet
package assignment06.exercise02;

public class Main
{
    public static void main(String[] args)
    {
        Box<Integer, Integer> boxIntInt = new Box<>(42, 53);
        Box<Number, String> boxNumStr = new Box<>(13, "hello");
        Box<Double, String> boxDoubleStr = new Box<>(56.78, "goodbye");
        Box<String, Character> boxStrChar1 = new Box<>("abc", '!');
        Box<String, Character> boxStrChar2 = new Box<>("def", '?');
        Box<Double, Number> boxDoubleNum = new Box<>(99.99, 0);
        
        System.out.println("init:");
        System.out.println("  boxIntInt = " + boxIntInt);
        System.out.println("  boxNumStr = " + boxNumStr);
        System.out.println("  boxDoubleStr = " + boxDoubleStr);
        System.out.println("  boxStrChar1 = " + boxStrChar1);
        System.out.println("  boxStrChar2 = " + boxStrChar2);
        System.out.println("  boxDoubleNum = " + boxDoubleNum);
        System.out.println();
        
        // copy 42 from boxIntInt.first into boxNumStr.first
        boxIntInt.moveFirstTo(boxNumStr);
        System.out.println("boxIntInt.moveFirstTo(boxNumStr):");
        System.out.println("  boxNumStr = " + boxNumStr);
        System.out.println();
        
        // copy 56.78 and "goodbye" from boxDoubleStr into boxNumStr
        boxNumStr.moveItemsFrom(boxDoubleStr);
        System.out.println("boxNumStr.moveItemsFrom(boxDoubleStr):");
        System.out.println("  boxNumStr = " + boxNumStr);
        System.out.println();
        
        // swap first and second between boxStrChar1 and boxStrChar2
        boxStrChar1.swapItemsWith(boxStrChar2);
        System.out.println("boxStrChar1.swapItemsWith(boxStrChar2):");
        System.out.println("  boxStrChar1 = " + boxStrChar1);
        System.out.println("  boxStrChar2 = " + boxStrChar2);
        System.out.println();
        
        // copy 99.99 to boxDoubleNum.second
        Box.moveFirstToSecond(boxDoubleNum);
        System.out.println("Box.moveFirstToSecond(boxDoubleNum):");
        System.out.println("  boxDoubleNum = " + boxDoubleNum);
        System.out.println();
        
        // swap 42 and 53 in boxIntInt
        Box.swapItems(boxIntInt);
        System.out.println("Box.swapItems(boxIntInt):");
        System.out.println("  boxIntInt = " + boxIntInt);
        System.out.println();
    
        /* Compilation errors:
        
        // error: Integer is not a superclass of Number
        boxNumStr.moveFirstTo(boxIntInt);
    
        // error: Number does not extend Double
        boxDoubleStr.moveItemsFrom(boxNumStr);
    
        // error: Number is not the same type as Double
        boxDoubleStr.swapItemsWith(boxNumStr);
    
        // error: String is not a superclass of Number
        Box.moveFirstToSecond(boxNumStr);
    
        // error: Double is not the same type as Number
        Box.swapItems(boxDoubleNum);
        
        */
    }
}
