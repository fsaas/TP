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
}
