import java.util.Scanner;

public class AppView {
    private Scanner _scanner;

    public AppView()
    {
        this._scanner = new Scanner(System.in);
    }

    public void outuptMessage(MessageID notice_endProgram) {
    }

    public void outputMessage(MessageID error_failInputGraph) {
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
}
