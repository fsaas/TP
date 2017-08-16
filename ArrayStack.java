public class ArrayStack<Element> {
    private static final int DEFAULT_MAX_STACK_SIZE = 100;
    private int _maxSize;
    private int _top;
    private Element[] _elements;

    public ArrayStack(Element numOfVerticesInGraph) {
        this._maxSize = (int) numOfVerticesInGraph;
        this._top = 0;
        this._elements = (Element[]) new Object[this._maxSize];
    }

    public boolean isEmpty()
    {
        return this._top == 0;
    }
    public boolean isFull()
    {
        return this._top == this._maxSize;
    }
    public int length()
    {
        return this._top;
    }
    public boolean push(Element anElement)
    {
        if(isFull()){
            return false;
        }
        else{
            this._top++;
            this._elements[this._top] = anElement;
            return true;
        }
    }
    public Element pop()
    {
       if(isEmpty()){
           return null;
       }else{
           return this._elements[this._top--];
       }
    }
    public Element peek()
    {
        return this._elements[this._top];
    }

    public ArrayStackIterator arrayStackIterator()
    {
        return new ArrayStackIterator();
    }
    public class ArrayStackIterator{
        int _currentPosition;

        public boolean hasNext()
        {
           return this._currentPosition < _top;
        }
        public Element next()
        {
           return _elements[_top++];
        }
    }
}
