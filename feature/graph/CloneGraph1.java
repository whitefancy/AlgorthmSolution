package OJSolution.feature.graph;

import OJSolution.datastructure.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph1 {
    private List<Node> nodes = new ArrayList<>();
    private List<Node> nodes1 = new ArrayList<>();
    private List<Node> neighbors;
    private List<Node> neighbors1;
    private Node root;

    public Node cloneGraph(Node node) {

        root = cloneNode(node);
        nodes.add(node);
        nodes1.add(root);
        for (int j = 0; j < nodes.size(); j++) {
            node = nodes.get(j);
            cloneNodes(node);
        }
        for (int j = 0; j < nodes.size(); j++) {
            cloneNeighbors(j);
        }
        return root;
    }

    private void cloneNeighbors(int id) {

        neighbors = nodes.get(id).neighbors;
        neighbors1 = nodes1.get(id).neighbors;
        for (int j = 0; j < neighbors.size(); j++) {
            Node neighbor1 = Find1(nodes1, neighbors.get(j).val);
            neighbors1.add(neighbor1);
        }
    }

    private Node cloneNode(Node it) {
        int val = it.val;
        neighbors = new ArrayList<>();
        Node ne = new Node(val, neighbors);
        return ne;
    }

    private void cloneNodes(Node node) {
        for (int i = 0; i < neighbors.size(); i++) {
            Node neighbor = neighbors.get(i);
            int id = neighbor.val;
            if (!Find(nodes, id)) {
                nodes.add(neighbor);
                nodes1.add(cloneNode(neighbor));
            }
        }
    }

    private boolean Find(List<Node> nodes1, int val) {
        for (int i = 0; i < nodes1.size(); i++) {
            if (nodes1.get(i).val == val) {
                return true;
            }
        }
        return false;
    }

    private Node Find1(List<Node> nodes1, int val) {
        for (int i = 0; i < nodes1.size(); i++) {
            if (nodes1.get(i).val == val) {
                return nodes1.get(i);
            }
        }
        return nodes1.get(0);
    }
}
