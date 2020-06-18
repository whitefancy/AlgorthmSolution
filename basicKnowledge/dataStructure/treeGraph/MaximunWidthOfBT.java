package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 执行结果：
 * 通过
 */
public class MaximunWidthOfBT {
    int max = 0;
    Map<Integer, Integer> left = new HashMap<>();

    /**
     * 由于我们需要将给定树中的每个节点都访问一遍，我们需要遍历树。我们可以用深度优先搜索或者宽度优先搜索将树遍历。
     * <p>
     * 这个问题中的主要想法是给每个节点一个 position 值，如果我们走向左子树，那么 position -> position * 2，如果我们走向右子树，那么 position -> positon * 2 + 1。当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1。
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        DFS(root, 0, 1);
        return max;
    }

    void DFS(TreeNode node, int depth, int pos) {
        if (node == null) {
            return;
        }
        if (!left.containsKey(depth)) {
            left.put(depth, pos);
        }
        max = Math.max(max, pos - left.get(depth) + 1);
        DFS(node.left, depth + 1, pos * 2);
        DFS(node.right, depth + 1, pos * 2 + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
