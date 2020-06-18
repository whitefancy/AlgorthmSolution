package Algorithm.basicKnowledge.dataStructure.treeGraph.DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            list.add(root.val);
            stack.push(root);
            root = root.left;
            while (root == null && !stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
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
