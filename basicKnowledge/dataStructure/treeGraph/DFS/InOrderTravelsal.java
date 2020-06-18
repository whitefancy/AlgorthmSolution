package Algorithm.basicKnowledge.dataStructure.treeGraph.DFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 执行结果：
 * 通过
 */
public class InOrderTravelsal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
