package OJSolution.application.DFSBFS;

import OJSolution.tool.MultiTreeBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class MaxTreeDepth {
    private int maxDepth = 0;

    public static void main(String[] args) throws JsonProcessingException {
        String s = "{\"$id\":\"1\",\"children\":[{\"$id\":\"2\",\"children\":[{\"$id\":\"5\",\"children\":[],\"val\":5},{\"$id\":\"6\",\"children\":[],\"val\":6}],\"val\":3},{\"$id\":\"3\",\"children\":[],\"val\":2},{\"$id\":\"4\",\"children\":[],\"val\":4}],\"val\":1}";

        Node root = MultiTreeBuilder.String2Tree(s);
        System.out.println(new MaxTreeDepth().maxDepth(root));
    }

    /**
     * 给定一个 N 叉树，找到其最大深度。
     *
     * @param root
     * @return
     */
    private int maxDepth(Node root) {
        DFS(root, 0);
        return maxDepth;
    }

    private void DFS(Node root, int i) {
        if (root == null) {
            return;
        }
        i++;
        if (i > maxDepth) {
            maxDepth = i;
        }
        for (Node child : root.children) {
            DFS(child, i);
        }
    }
}
