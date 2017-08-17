public class TopologicalSort {
    private int[] _predecessorCount;
    private ArrayStack<Integer> _zeroCountVertices;
    private ArrayList<Integer> _sortedList;
    private AdjacencyListDirectedGraph _graph;

    public TopologicalSort(AdjacencyListDirectedGraph graph) {
        this._graph = graph;
        createAndSetPredecessorCount();
        this._zeroCountVertices = new ArrayStack<Integer>(this._graph);
        pushVerticesWithNoPredecessors();
        this._sortedList = new ArrayList<Integer>(graph);
    }

    private void pushVerticesWithNoPredecessors() {
        for(int target = 0; target<this._graph.get_numOfVertices(); target++){
            if(this._predecessorCount[target] == 0){
                this._zeroCountVertices.push(target);
            }
        }
    }

    private void createAndSetPredecessorCount() {
        this._predecessorCount = new int[this._graph.get_numOfVertices()];
        int countForPredecessor;
        for(int target =0 ; target<this._graph.get_numOfVertices(); target++)
        {
            countForPredecessor = 0;
            for(int finder = 0; finder<this._graph.get_numOfVertices(); finder++)
            {
                AdjacencyListDirectedGraph.AdjacencyListDirectedGrahpIterator iterator = this._graph.graphIterator(finder);
                while(iterator.hasNext())
                {
                    if(iterator.next().get_element().get_headVertex() == target){
                         countForPredecessor++;
                    }
                }
            }
            this._predecessorCount[target] = countForPredecessor;
        }
    }

    public ArrayList sortedList()
    {
        return this._sortedList;
    }

    public boolean perform() {
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

    private void showZeroCountVertices() {
        System.out.print("- 출력 가능한 vertex 들의 stack :");
        System.out.print("<Top>");
        ArrayStack.ArrayStackIterator iterator = this._zeroCountVertices.arrayStackIterator();
        if(iterator.hasNext())
            System.out.print(iterator.next());
        System.out.print("<Bottom>");
    }

    private void showPredecessorCount() {
        System.out.println("- 각 vertex의 선행 vertex 수 :");
        for(int i = 0; i<this._graph.get_numOfVertices();i++){
            System.out.println("["+i+"] "+ this._predecessorCount[i]);
        }
    }
}
