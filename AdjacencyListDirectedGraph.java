public class AdjacencyListDirectedGraph {
    private Node<DirectedEdge>[] _listDirectedGraph;
    private int _numOfVertices;
    public AdjacencyListDirectedGraph(int numOfVertex) {
        this._listDirectedGraph = (Node<DirectedEdge>[]) new Object[numOfVertex];
        this._numOfVertices = numOfVertex;
        for(int i = 0; i<numOfVertex; i++)
        {
            this._listDirectedGraph[i] = new Node<DirectedEdge>();
        }
    }

    public boolean addEdge(DirectedEdge givenEdge) {
        if(isVertexValid(givenEdge)){
            if(doesEdgeExist(givenEdge)){

            }
        }
    }

    private boolean doesEdgeExist(DirectedEdge givenEdge) {
        int tailVertex = givenEdge.get_tailVertex();
        int headVertex = givenEdge.get_headVertex();
        Node<DirectedEdge> finder =  this._listDirectedGraph[tailVertex];
        while(finder != null)
        {
            if(Integer.valueOf(String.valueOf(finder.get_element())) == headVertex)
                return true;
            else
                finder = finder.get_next();
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
