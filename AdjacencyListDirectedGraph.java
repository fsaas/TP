public class AdjacencyListDirectedGraph {
    private Node<Integer>[] _listDirectedGraph;
    private int _numOfVertices;
    public AdjacencyListDirectedGraph(int numOfVertex) {
        this._listDirectedGraph = (Node<Integer>[]) new Object[numOfVertex];
        this._numOfVertices = numOfVertex;
        for(int i = 0; i<numOfVertex; i++)
        {
            this._listDirectedGraph[i] = new Node<Integer>();
        }
    }

    public int get_numOfVertices() {
        return _numOfVertices;
    }

    public boolean addEdge(DirectedEdge givenEdge) {
        int tailVertex = givenEdge.get_tailVertex();
        int headVertex = givenEdge.get_headVertex();
        Node<Integer> header =  this._listDirectedGraph[tailVertex];
        Node<Integer> newNode = new Node<Integer>(tailVertex);
        if(isVertexValid(givenEdge)){
            if(doesEdgeExist(givenEdge)){
               newNode.set_next(header.get_next());
               header.set_next(newNode);
               return true;
            }
        }
        return false;
    }

    private boolean doesEdgeExist(DirectedEdge givenEdge) {
        int tailVertex = givenEdge.get_tailVertex();
        int headVertex = givenEdge.get_headVertex();
        Node<Integer> header = this._listDirectedGraph[tailVertex];
        Node<Integer> currentNode = header.get_next();
        while(currentNode != null)
        {
            if(Integer.valueOf(String.valueOf(currentNode.get_element())) == headVertex)
                return true;
            else
                currentNode = currentNode.get_next();
        }
        return false;
    }

    private boolean isVertexValid(DirectedEdge givenEdge) {
        int tailVertex = givenEdge.get_tailVertex();
        int headVertex = givenEdge.get_headVertex();
        if(tailVertex > -1 && tailVertex <this._numOfVertices){
            if(headVertex> -1 && headVertex < this._numOfVertices){
               return true;
            }
        }
        return false;
    }

    public AdjacencyListDirectedGrahpIterator graphIterator(int i){
        return new AdjacencyListDirectedGrahpIterator(1);
    }

    public class AdjacencyListDirectedGrahpIterator{
        private int _currentPosition;
        private Node<Integer> header;

        public AdjacencyListDirectedGrahpIterator(int i) {
            this._currentPosition = 0;
            header = _listDirectedGraph[i];
        }

        public boolean hasNext()
        {
            Node<Integer> finder = header;
            for(int i = 0; i<this._currentPosition; i++)
            {
                finder = finder.get_next();
            }
            return finder.get_next() != null;
        }

        public int next()
        {
            Node<Integer> finder = header;
            for(int i = 0; i<this._currentPosition; i++)
            {
                finder = finder.get_next();
            }
            return finder.get_element();
        }
    }
}
