public class TopologicalSort {
    private int[] _predecessorCount;
    private ArrayStack<Integer> _zeroCountVertices;
    private ArrayList<Integer> _sortedList;
    private AdjacencyListDirectedGraph _graph;

    public TopologicalSort(AdjacencyListDirectedGraph graph) {
        this._graph = graph;
        createAndSetPredecessorCount();
        int numOfVerticesInGraph = graph.get_numOfVertices();
        this._zeroCountVertices = new ArrayStack<Integer>(numOfVerticesInGraph);
        pushVerticesWithNoPredecessors();
        this._sortedList = new ArrayList<Integer>();
    }

    public ArrayList sortedList()
    {
        return this._sortedList;
    }

    public void perform() {
        int tailVertex, headVertex;
        showPredecessorCount();
        while(!this._zeroCountVertices.isEmpty())
        {
            tailVertex = this._zeroCountVertices.pop();
            this._sortedList.add(tailVertex);
            System.out.println("- Pop & Output : " + tailVertex);
            AdjacencyListDirectedGraph.AdjacencyListDirectedGrahpIterator adjacencyListDirectedGrahpIterator = this._graph.graphIterator(tailVertex);
            while(adjacencyListDirectedGrahpIterator.hasNext())
            {
                headVertex= adjacencyListDirectedGrahpIterator.next().get_element().get_headVertex();
                _predecessorCount[headVertex]--;
                if(_predecessorCount[headVertex] == 0)
                    this._zeroCountVertices.push(headVertex);
            }
            showPredecessorCount();
            showZeroCountVertices();
        }
        return (this._sortedList.size() == this._graph.get_numOfVertices());
    }
}
