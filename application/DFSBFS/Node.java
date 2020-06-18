package OJSolution.application.DFSBFS;

import java.util.List;

public class Node {
    public int $id;
    public int val;
    List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}