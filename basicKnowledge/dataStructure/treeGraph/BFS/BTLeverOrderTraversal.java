package Algorithm.basicKnowledge.dataStructure.treeGraph.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class BTLeverOrderTraversal {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * 执行结果：
     * 通过
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            queue.offer(null);
        }
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                ans.add(list);
                list = new LinkedList<>();
                queue.offer(null);
                root = queue.poll();
            }
            if (root == null) {
                break;
            }
            list.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return ans;
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
