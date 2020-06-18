package Algorithm.basicKnowledge.Algothrom.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 */
public class AllEleIn2BST {
    /**
     * 中序遍历+归并排序
     *
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = inOrder(root1);
        List<Integer> l2 = inOrder(root2);
        return merge(l1, l2);
    }

    List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> ans = new ArrayList<>();
        ans.addAll(l2);
        ans.addAll(l1);
        Collections.sort(ans);
        return ans;

    }

    List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ans;
        }
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
            if (root == null && stack.isEmpty()) {
                break;
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
