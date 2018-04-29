package project08.list;

import java.util.ListIterator;

public class Iterator<T> implements ListIterator<T> {
    Node<T> current;

    public Iterator(Node<T> current) {
        this.current = current;
    }

    public boolean hasNext() {
        return current.next != current.next.next;
    }

    public T next() {
        if (!hasNext()) {
            throw new Error("Out of the list !");
        }
        current = current.next;
        return current.content;
    }

    public boolean hasPrevious() {
        return current.previous != current.previous.previous;
    }

    public T previous() {
        current = current.previous;
        return current.content;
    }

    public int nextIndex() {
        int idx = 1;
        Node<T> n = current;
        while (n.previous != n.previous.previous) {
            n = n.previous;
            idx++;
        }
        return idx;
    }

    public int previousIndex() {
        return nextIndex()-2;
    }

    public void remove() {
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current = current.previous;
    }

    public void set(T e) {
        current.content = e;
    }

    public void add(T e) {
        Node<T> n = new Node<>(e);
        n.previous = current.previous;
        n.next = current;
        current.previous = n;
        n.previous.next = n;
    }

}

