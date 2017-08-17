import java.util.Scanner;

public class AppView {
    private Scanner _scanner;

    public AppView()
    {
        this._scanner = new Scanner(System.in);
    }

    public void outuptMessage(MessageID notice_endProgram) {
    }

    public void outputMessage(MessageID givenMessage) {
        switch (givenMessage)
        {
            case Error_WrongEdge:
                System.out.print("잘못된 Edge");
                break;
        }
    }

    public int getNumOfVertex() {
        System.out.print("Vertex 수를 입력");
        return this._scanner.nextInt();
    }

    public int getNumOfEdge() {
        System.out.print("Edge수를 입력");
        return this._scanner.nextInt();
    }

    public DirectedEdge inputEdge() {
        System.out.print("Edge를 입력:");
        return new DirectedEdge(this._scanner.nextInt(), this._scanner.nextInt());
    }

    public void showGraph(AdjacencyListDirectedGraph graph) {
        int numOfVertex = graph.get_numOfVertices();
        for(int i =0; i<numOfVertex; i++)
        {
            AdjacencyListDirectedGraph.AdjacencyListDirectedGrahpIterator iterator = graph.graphIterator(i);
            System.out.print("["+ i +"] ");
            for(int j = 0; j < numOfVertex; j++)
            {
                if(iterator.hasNext())
                {
                    System.out.print(iterator.next().get_element().get_headVertex()+ " ");
                }
            }
            this.outputBlankLine();
        }
    }

    private void outputBlankLine() {
        System.out.println();
    }

    public void showSortedList(TopologicalSort topologicalSort) {
        ArrayList<Integer> sortedList = topologicalSort.sortedList();
        ArrayList.ArrayListIterator iterator = sortedList.arrayListIterator();
        System.out.println("! Topological Sort의 결과는 다음과 같습니다.");
        while(iterator.hasNext())
            System.out.print(iterator.next());
    }
}
