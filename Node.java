public class Node<T> {
    private T _element;
    private Node<T> _next;

    public T get_element() {
        return _element;
    }

    public Node<T> get_next() {
        return _next;
    }
}
