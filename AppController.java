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
        this._appView.showSortedList(this._topologicalSort);
    }

    private void showGraph()
    {
        this._appView.showGraph(this._graph);

    }

    private boolean inputAndMakeGraph() {
        int numOfVertex = this._appView.getNumOfVertex();
        int numOfEdge = this._appView.getNumOfEdge();
        int count = 0;
        this._graph = new AdjacencyListDirectedGraph(numOfVertex);

        while(count < numOfEdge)
        {
            System.out.print(count);
            if(this._graph.addEdge(this._appView.inputEdge()))
            {
                count++;
            }else{
                System.out.print(count);
                this._appView.outputMessage(MessageID.Error_WrongEdge);
            }
        }
        return count == numOfEdge;
    }
}
