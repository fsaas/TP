public class ArrayList<T> {
    private T _element[];
    private int _size;
    private int _maxSize;

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
            this._size++;
            this._element[this._size] = anElement;
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
            return this._currentPosition == _size;
        }
        public T next()
        {
           return _element[this._currentPosition++];
        }
    }

}
