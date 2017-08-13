public class Edge {
    private int _tailVertex;
    private int _headVertex;

    public Edge(int tailVertex, int headVertex) {
        this._tailVertex = tailVertex;
        this._headVertex = headVertex;
    }

    public int get_tailVertex() {
        return _tailVertex;
    }

    public int get_headVertex() {
        return _headVertex;
    }
}
