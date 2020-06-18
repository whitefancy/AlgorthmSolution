package OJSolution.datastructure.graph;

public interface Graph {

    public int getNumOfEdges();

    public int getNumOfVertex();

    public Object getValueByIndex(int i);

    public int getWeight(int v1, int v2);

    public void insertVertex(Object vertex);

    public void insertEdge(int v1, int v2, int weight);

    public void deleteEdge(int v1, int v2);

    public int getFirstNeighbor(int index);

    public int getNextNeighbor(int v1, int v2);
}
