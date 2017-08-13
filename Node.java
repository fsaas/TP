public class Node<T> {
    private T _element;
    private Node<T> _next;

    public Node(T tailVertex) {
    }

    public Node() {

    }

    public T get_element() {
        return _element;
    }

    public Node<T> get_next() {
        return _next;
    }

    public void set_next(Node<T> _next) {
        this._next = _next;
    }
}
