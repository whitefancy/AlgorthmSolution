package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.ArrayDeque;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 执行结果：
 * 通过
 */
public class ValidBST {
    /**
     * 中序遍历为有序序列
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int pre = 0;
        boolean isValid = false;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                return true;
            }
            root = stack.pop();
            if (isValid == false) {
                pre = root.val;
                isValid = true;
            } else {
                if (root.val <= pre) {
                    return false;
                } else {
                    pre = root.val;
                }
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
