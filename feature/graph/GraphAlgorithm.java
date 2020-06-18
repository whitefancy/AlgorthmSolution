package OJSolution.feature.graph;


import OJSolution.datastructure.graph.ALGraph;
import OJSolution.datastructure.graph.Graph;
import OJSolution.datastructure.tree.TreeNode;

import java.util.*;

public class GraphAlgorithm {

    private boolean visited[];

    public void test() {
        int n = 4, e = 4;
        Graph graph = new ALGraph(n);
        //Graph graph = new AMGraph(n);
        for (int i = 0; i < n; i++) {
            graph.insertVertex("V" + i);
        }
        graph.insertEdge(0, 3, 2);
        graph.insertEdge(0, 2, 2);
        graph.insertEdge(1, 3, 2);
        graph.insertEdge(2, 3, 2);
        System.out.println("结点个数是：" + graph.getNumOfVertex());
        System.out.println("边的个数是：" + graph.getNumOfEdges());
        List<TreeNode> list = dFSForest(graph);
        //traverseBFS(graph);
        graph.deleteEdge(1, 3);
        System.out.println("删除<V1,V2>边后...");
        System.out.println("结点个数是：" + graph.getNumOfVertex());
        System.out.println("边的个数是：" + graph.getNumOfEdges());
    }

    /**
     * 图的DFS遍历
     * 复杂度 邻接表 O(n+e) 邻接矩阵O(n^2)
     *
     * @param G
     */
    public void DFS1(Graph G) {
        visited = new boolean[G.getNumOfVertex()];
        for (int v = 0; v < G.getNumOfVertex(); v++) {
            if (!visited[v]) {
                recursiveDFS(G, v);
            }
        }
    }

    private void recursiveDFS(Graph G, int v) {
        visited[v] = true;
        System.out.println(G.getValueByIndex(v));
        for (int w = G.getFirstNeighbor(v); w >= 0; w = G.getNextNeighbor(v, w)) {
            if (!visited[w]) {
                recursiveDFS(G, w);
            }
        }
    }

    public void DFS2(Graph G) {
        Stack stack = new Stack();
        visited = new boolean[G.getNumOfVertex()];
        for (int v = 0; v < G.getNumOfVertex(); v++) {
            if (!visited[v]) {
                visited[v] = true;
                System.out.println(G.getValueByIndex(v));
                stack.push(v);
                while (!stack.isEmpty()) {
                    int cur = (int) stack.peek();
                    boolean hasNeighbor = false;
                    for (int w = G.getFirstNeighbor(cur); w != -1; w = G.getNextNeighbor(cur, w)) {
                        if (!visited[w]) {
                            hasNeighbor = true;
                            visited[w] = true;
                            System.out.println(G.getValueByIndex(w));
                            stack.push(w);
                        }
                    }
                    if (!hasNeighbor) {
                        stack.pop();
                    }
                }
            }
        }
    }

    /**
     * 图的BFS遍历
     * 复杂度 邻接表 O(n+e) 邻接矩阵O(n^2)
     *
     * @param G
     */
    public void traverseBFS(Graph G) {
        // 复杂度 邻接表 O(n+e) 邻接矩阵O(n^2)
        Queue queue = new ArrayDeque();
        visited = new boolean[G.getNumOfVertex()];
        for (int v = 0; v < G.getNumOfVertex(); v++) {
            if (!visited[v]) {
                visited[v] = true;
                System.out.println(G.getValueByIndex(v));
                queue.add(v);
                while (!queue.isEmpty()) {
                    int cur = (int) queue.poll();
                    for (int w = G.getFirstNeighbor(cur); w != -1; w = G.getNextNeighbor(cur, w)) {
                        if (!visited[w]) {
                            visited[w] = true;
                            System.out.println(G.getValueByIndex(w));
                            queue.add(w);
                        }
                    }
                }
            }
        }
    }

    /**
     * 使用DFS遍历的图的生成森林
     *
     * @param G
     * @return
     */
    private List<TreeNode> dFSForest(Graph G) {
        List<TreeNode> forest = new ArrayList<>();
        visited = new boolean[G.getNumOfVertex()];
        for (int v = 0; v < G.getNumOfVertex(); v++) {
            if (!visited[v]) {
                TreeNode root = new TreeNode((Integer) G.getValueByIndex(v));
                forest.add(root);
                dFSTree(G, v, root);
            }
        }
        return forest;
    }

    /**
     * 使用DFS遍历的图的生成树
     *
     * @param G
     * @param v
     * @param tree
     */
    private void dFSTree(Graph G, int v, TreeNode tree) {
        visited[v] = true;
        for (int w = G.getFirstNeighbor(v); w >= 0; w = G.getNextNeighbor(v, w)) {
            if (!visited[w]) {
                TreeNode child = new TreeNode((Integer) G.getValueByIndex(w));
                tree.addChild(child);
                dFSTree(G, w, child);
            }
        }
    }
}
