package OJSolution.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Adjacency list graph
 * 邻接表结构的图
 */
public class ALGraph implements Graph {
    // Adjacency matrix graph
    private List vertexList;
    private List<Arc>[] edges;
    private int numOfEdges;

    public ALGraph(int n) {
        edges = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new LinkedList<>();
        }
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
        for (int i = 0; i < edges[v1].size(); i++) {
            if (edges[v1].get(i).getTail() == v2) {
                return edges[v1].get(i).getWeight();
            }
        }
        return 0;
    }

    @Override
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    @Override
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1].add(new Arc(v2, weight));
        numOfEdges++;
    }

    @Override
    public void deleteEdge(int v1, int v2) {
        for (int i = 0; i < edges[v1].size(); i++) {
            if (edges[v1].get(i).getTail() == v2) {
                edges[v1].remove(i);
                numOfEdges--;
            }
        }

    }

    @Override
    public int getFirstNeighbor(int index) {
        if (edges[index].size() > 0) {
            return edges[index].get(0).getTail();
        }
        return -1;
    }

    @Override
    public int getNextNeighbor(int v1, int v2) {
        for (int i = 0; i < edges[v1].size() - 1; i++) {
            if (edges[v1].get(i).getTail() == v2) {
                return edges[v1].get(i + 1).getTail();
            }
        }
        return -1;
    }
}
