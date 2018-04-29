package project07;

public class Node<T> {
    Node<T> previous;
    Node<T> next;
    T content;

    public Node(T content) {
        this.content = content;
    }
}
