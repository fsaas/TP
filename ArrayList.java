public class ArrayList<T> {
    private T _element[];
    private int _size;
    private int _maxSize;

    public ArrayList(AdjacencyListDirectedGraph graph) {
        this._element = (T[]) new Object[graph.get_numOfVertices()];
        this._size = 0;
        this._maxSize = graph.get_numOfVertices();
    }

    public boolean isFull()
    {
        return this._size == this._maxSize;
    }
    public boolean isEmpty()
    {
        return this._size == 0;
    }
    public int size()
    {
        return this._size;
    }

    public boolean add(T anElement)
    {
        if(isFull())
        {
            return false;
        }
        else{
            this._element[this._size] = anElement;
            this._size++;
            return true;
        }
    }

    public ArrayListIterator arrayListIterator(){
        return new ArrayListIterator();
    }
    public class ArrayListIterator{
        int _currentPosition;

        public boolean hasNext()
        {
            return this._currentPosition < _size;
        }
        public T next()
        {
           return _element[this._currentPosition++];
        }
    }

}
