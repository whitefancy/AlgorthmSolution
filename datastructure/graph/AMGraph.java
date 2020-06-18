package OJSolution.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接矩阵结构的图
 */
public class AMGraph implements Graph {
    // Adjacency matrix graph
    private List vertexList;
    private int[][] edges;
    private int numOfEdges;

    public AMGraph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    @Override
    public int getNumOfVertex() {
        return vertexList.size();
    }

    @Override
    public int getNumOfEdges() {
        return numOfEdges;
    }

    @Override
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    @Override
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    @Override
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    @Override
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdges++;
    }

    @Override
    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdges--;
    }

    @Override
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }
}
