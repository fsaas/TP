public class AdjacencyListDirectedGraph {
    private Node<DirectedEdge>[] _adjacency;
    private int _numOfVertices;

    public AdjacencyListDirectedGraph(int numOfVertex) {
        this._adjacency = (Node<DirectedEdge>[]) new Node[numOfVertex];
        this._numOfVertices = numOfVertex;
        for (int i = 0; i < numOfVertex; i++) {
            this._adjacency[i] = new Node<DirectedEdge>();
        }
    }

    public int get_numOfVertices() {
        return _numOfVertices;
    }

    public boolean addEdge(DirectedEdge givenEdge) {
        int tailVertex = givenEdge.get_tailVertex();
        int headVertex = givenEdge.get_headVertex();
        if (isVertexValid(givenEdge)) {
            if (doesNotEdgeExist(givenEdge)) {
                Node<DirectedEdge> header = this._adjacency[tailVertex];
                Node<DirectedEdge> newNode = new Node<DirectedEdge>(givenEdge.get_tailVertex(), givenEdge.get_headVertex());
                newNode.set_next(header.get_next());
                header.set_next(newNode);
                return true;
            }
        }
        return false;
    }

    private boolean doesNotEdgeExist(DirectedEdge givenEdge) {
        return !doesEdgeExist(givenEdge);
    }

    private boolean doesEdgeExist(DirectedEdge givenEdge) {
        int tailVertex = givenEdge.get_tailVertex();
        int headVertex = givenEdge.get_headVertex();
        Node<DirectedEdge> header = this._adjacency[tailVertex];
        Node<DirectedEdge> currentNode = header.get_next();
        while (currentNode != null) {
            if ((currentNode.get_element().get_headVertex()) == headVertex)
                return true;
            else
                currentNode = currentNode.get_next();
        }
        return false;
    }

    private boolean isVertexValid(DirectedEdge givenEdge) {
        int tailVertex = givenEdge.get_tailVertex();
        int headVertex = givenEdge.get_headVertex();
        if (tailVertex > -1 && tailVertex < this._numOfVertices) {
            if (headVertex > -1 && headVertex < this._numOfVertices) {
                return true;
            }
        }
        return false;
    }

    public AdjacencyListDirectedGrahpIterator graphIterator(int i) {
        return new AdjacencyListDirectedGrahpIterator(i);
    }

    public class AdjacencyListDirectedGrahpIterator {
        private int _currentPosition;
        private Node<DirectedEdge> header;

        public AdjacencyListDirectedGrahpIterator(int i) {
            this._currentPosition = 0;
            header = _adjacency[i];
        }

        public boolean hasNext() {
            Node<DirectedEdge> finder = header;
            for (int i = 0; i < this._currentPosition; i++) {
                finder = finder.get_next();
            }
            return finder.get_next() != null;
        }

        public Node<DirectedEdge> next() {
            Node<DirectedEdge> finder = header;
            for (int i = 0; i < this._currentPosition; i++) {
                finder = finder.get_next();
            }
            this._currentPosition++;
            return finder.get_next();
        }
    }
}
