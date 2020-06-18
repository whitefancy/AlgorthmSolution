package Algorithm.basicKnowledge.dataStructure.treeGraph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * }
 */
public class PostOrderTraversal {
    /**
     * 在二叉树的后序遍历中，常常依靠队列，要么在队列中前向插入，要么利用队列去判断该节点是否遍历过，现在要求只能利用栈去做，不能用队列去辅助判断（即，只允许在队列尾部添加答案）
     * <p>
     * 这道题的难点在于仅利用栈去判断该节点是否为父结点，创新性思路是每次在栈中压入父节点后压入nullptr，之后再依次压入右子节点和左子节点。
     * 执行结果：
     * 通过
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                list.add(stack.pop().val);
                continue;
            }
            stack.push(null);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
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