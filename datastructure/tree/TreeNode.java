package OJSolution.datastructure.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    private Object val;
    private List<TreeNode> children;

    public TreeNode(Object i) {
        val = i;
    }

    public void addChild(TreeNode node) {
        if (children == null) {
            children = new LinkedList<>();
        }
        children.add(node);
    }
}
