public class AppController {
    private AppView _appView;
    private TopologicalSort _topologicalSort;
    private AdjacencyListDirectedGraph _graph;

    public AppController()
    {
        this._appView = new AppView();
    }

    public void run() {
        if(this.inputAndMakeGraph())
        {
           this.showGraph();
           this._topologicalSort = new TopologicalSort(this._graph);
           this._topologicalSort.perform();
           this.showSortedList();
           this._appView.outuptMessage(MessageID.Notice_EndProgram);
        }
        else{
            this._appView.outputMessage(MessageID.Error_FailInputGraph);
        }
    }

    private void showSortedList() {
    }

    private void showGraph()
    {

    }

    private boolean inputAndMakeGraph() {
        int numOfVertex = this._appView.getNumOfVertex();
        int numOfEdge = this._appView.getNumOfEdge();
        int count = 0;
        this._graph = new AdjacencyListDirectedGraph(numOfVertex);

        while(count < numOfEdge)
        {
            if(this._graph.addEdge(this._appView.inputEdge()))
            {
                count++;
            }else{
                this._appView.outputMessage(MessageID.Error_WrongEdge);
            }
        }
        return count == numOfEdge;
    }
}
