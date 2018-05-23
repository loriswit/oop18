package project11.list;

public class Node<T> {
    Node<T> previous;
    Node<T> next;
    T content;

    public Node(T content) {
        this.content = content;
    }
}
