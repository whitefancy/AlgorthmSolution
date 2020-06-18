package OJSolution.feature.graph;

import OJSolution.datastructure.graph.Node;

import java.util.*;

class GraphTravelbyNodelist {
    private Set<Integer> flag = new HashSet<>();
    private List<Node> nodes = new ArrayList<>();
    private List<Node> nodes1 = new ArrayList<>();
    private List<Node> neighbors;
    private List<Node> neighbors1;
    private Node root;

    public Node cloneGraph(Node node) {
        root = new Node();
        neighbors = new ArrayList<>();
        root.neighbors = neighbors;
        root.val = node.val;
        DFS_Map(node, root, 1);
        addRef(nodes, nodes1);
        return root;
    }

    private void addRef(List<Node> nodes, List<Node> nodes1) {
        for (int i = 0; i < nodes.size(); i++) {
            neighbors = nodes.get(i).neighbors;
            neighbors1 = nodes1.get(i).neighbors;
            for (int j = neighbors1.size(); j < neighbors.size(); j++) {
                Node neighbor = neighbors.get(j);
                Integer id = neighbor.val;
                if (flag.contains(id)) {
                    Node neig = DFSFind(nodes1, id);
                    neighbors1.add(neig);
                }
            }
        }
    }

    private void DFS_Map(Node node, Node root, int type) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(node);
        stack1.push(root);

        while (!stack.empty()) {
            Node cur = stack.pop();
            flag.add(cur.val);
            Node ans = stack1.pop();
            nodes.add(cur);
            nodes1.add(ans);
            neighbors = cur.neighbors;
            neighbors1 = ans.neighbors;
            for (int i = neighbors1.size(); i < neighbors.size(); i++) {
                Node neighbor = neighbors.get(i);
                Integer id = neighbor.val;
                if (flag.contains(id)) {
                    Node neig = DFSFind(nodes1, id);
                    neighbors1.add(neig);
                } else {
                    stack.push(neighbor);
                    Node nei = new Node();
                    nei.val = id;
                    List<Node> neigs = new ArrayList<>();
                    nei.neighbors = neigs;
                    neighbors1.add(nei);
                    stack1.push(nei);
                    break;
                }
            }
        }
    }

    private Node DFSFind(List<Node> nodes1, int val) {
        for (int i = 0; i < nodes1.size(); i++) {
            if (nodes1.get(i).val == val) {
                return nodes1.get(i);
            }
        }
        return nodes1.get(0);
    }
}