package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * <p>
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * <p>
 * 执行结果：
 * 通过
 */
public class AddOneRowToTree {
    Deque<TreeNode> queue = new LinkedList<>();
    int cd = 1;

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        if (d == 1) {
            TreeNode nnode = new TreeNode(v);
            nnode.left = root;
            return nnode;
        }
        queue.add(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                cd++;
                if (cd == d) {
                    break;
                }
                queue.add(null);
            } else {
                if (cd + 1 == d) {
                    TreeNode nnode = new TreeNode(v);
                    nnode.left = node.left;
                    node.left = nnode;
                    nnode = new TreeNode(v);
                    nnode.right = node.right;
                    node.right = nnode;
                } else if (cd + 1 < d) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return root;
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
