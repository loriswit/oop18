// Loris Witschard & Nicolas Bovet
package assignment05.exercise02;

public class Stack<E>
{
    private E[] content;
    private int nbElement;
    
    public Stack()
    {
        content = (E[]) new Object[200];
        nbElement = 0;
    }
    
    public void push(E elem)
    {
        content[nbElement++] = elem;
    }
    
    public void pop()
    {
        content[--nbElement] = null;
    }
    
    public void printElements()
    {
        for(int i = 0; i < nbElement; i++)
            System.out.println(content[i] + " (index: " + i + ")");
    }
    
}
