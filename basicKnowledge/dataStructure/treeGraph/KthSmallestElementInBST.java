package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.ArrayDeque;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 执行结果：
 * 通过
 */
public class KthSmallestElementInBST {
    /**
     * 二叉搜索树中序遍历时，为元素顺序
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int m = 0;
        //使用栈来中序遍历 非常简洁
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            m++;
            if (m == k) {
                return root.val;
            }
            root = root.right;
        }
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
