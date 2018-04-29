// Loris Witschard & Nicolas Bovet
package assignment06.exercise02;

class Box<F, S>
{
    private F first;
    private S second;
    
    Box(F first, S second)
    {
        this.first = first;
        this.second = second;
    }
    
    void moveFirstTo(Box<? super F, ?> box)
    {
        box.first = first;
    }
    
    void moveItemsFrom(Box<? extends F, ? extends S> box)
    {
        first = box.first;
        second = box.second;
    }
    
    void swapItemsWith(Box<F, S> box)
    {
        F tempFirst = box.first;
        S tempSecond = box.second;
        box.first = first;
        box.second = second;
        first = tempFirst;
        second = tempSecond;
    }
    
    static <T> void moveFirstToSecond(Box<? extends T, ? super T> box)
    {
        box.second = box.first;
    }
    
    static <T> void swapItems(Box<T, T> box)
    {
        T temp = box.first;
        box.first = box.second;
        box.second = temp;
    }
    
    @Override
    public String toString()
    {
        return "first: " + first + "; second: " + second;
    }
}
