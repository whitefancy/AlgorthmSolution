package Algorithm.basicKnowledge.dataStructure.treeGraph.depth;

import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 * 面试题55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class DepthOfBTree {
    /**
     * 执行结果：
     * 通过
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int dp = 0;
        if (root != null) {
            queue.offer(root);
            queue.offer(null);
        }
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                dp++;
                queue.offer(null);
                root = queue.poll();
                if (root == null) {
                    break;
                }
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return dp;
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
