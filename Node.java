public class Node<T> {
    private T _element;
    private Node<T> _next;

    public Node() {

    }

    public Node(int tailVertex, int headVertex) {
        this._element = (T) new DirectedEdge(tailVertex, headVertex);
    }

    public T get_element() {
        return this._element;
    }

    public Node<T> get_next() {
        return _next;
    }

    public void set_next(Node<T> _next) {
        this._next = _next;
    }
}
