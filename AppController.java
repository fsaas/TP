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
}
