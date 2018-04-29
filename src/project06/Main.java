// Loris Witschard & Nicolas Bovet
package project06;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class Main
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.println("size: " + list.size());
        for(Integer i : list)
            System.out.println(i);
        System.out.println();
        
        // removes 2nd item
        list.remove(1);
        
        System.out.println("size: " + list.size());
        for(Integer i : list)
            System.out.println(i);
        System.out.println();
        
        list.add(5);
        
        System.out.println("size: " + list.size());
        for(Integer i : list)
            System.out.println(i);
        System.out.println();
    }
}

class LinkedList<T> extends AbstractSequentialList<T>
{
    private Node<T> tail;
    private Node<T> head;
    
    private int size = 0;
    
    public LinkedList()
    {
        tail = new Node<>(null, tail);
        head = new Node<>(null, tail);
    }
    
    @Override
    public ListIterator<T> listIterator(int index)
    {
        return new LinkedListIterator(index);
    }
    
    @Override
    public int size()
    {
        return size;
    }
    
    private static class Node<T>
    {
        private T value;
        private Node<T> next;
        
        Node(T value, Node<T> next)
        {
            this.value = value;
            this.next = next;
        }
    }
    
    private class LinkedListIterator implements ListIterator<T>
    {
        private Node<T> node = head;
        private int index;
        
        LinkedListIterator(int index)
        {
            this.index = index;
            for(int i = 0; i < index; ++i)
                node = node.next;
        }
        
        @Override
        public boolean hasNext()
        {
            return node.next != tail;
        }
        
        @Override
        public T next()
        {
            ++index;
            node = node.next;
            return node.value;
        }
        
        @Override
        public boolean hasPrevious()
        {
            return node != head;
        }
        
        @Override
        public T previous()
        {
            --index;
            
            node = head;
            for(int i = 0; i < index; ++i)
                node = node.next;
            
            return node.value;
        }
        
        @Override
        public int nextIndex()
        {
            return index + 1;
        }
        
        @Override
        public int previousIndex()
        {
            return index - 1;
        }
        
        @Override
        public void remove()
        {
            previous();
            node.next = node.next.next;
            --size;
        }
        
        @Override
        public void set(T value)
        {
            node.value = value;
        }
        
        @Override
        public void add(T value)
        {
            node.next = new Node<>(value, node.next);
            ++size;
            next();
        }
    }
}
