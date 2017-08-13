public class AdjacencyListDirectedGraph {
    private Node<T>[] _listDirectedGraph;
    private int _numOfVertices;
    public AdjacencyListDirectedGraph(int numOfVertex) {
        this._listDirectedGraph = (Node<T>) new Object[numOfVertex];
        this._numOfVertices = numOfVertex;_
    }

    public boolean addEdge(DirectedEdge givenEdge) {
        if(isVertexValid(givenEdge)){
            if(doesEdgeExist(givenEdge)){

            }
        }
    }

    private boolean doesEdgeExist(DirectedEdge givenEdge) {
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
