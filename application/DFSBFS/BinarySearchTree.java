package OJSolution.application.DFSBFS;

import OJSolution.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class BinarySearchTree {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            boolean isValid = DFS(root, list);
            if (isValid) {
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i - 1) >= list.get(i)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean DFS(TreeNode p, List<Integer> list) {
        boolean isValid = true;
        if (p.left != null) {
            isValid = DFS(p.left, list);
        }
        if (isValid == false) {
            return isValid;
        }
        if (p.left != null && p.left.val >= p.val) {
            isValid = false;
            return isValid;
        }
        if (p.right != null && p.right.val <= p.val) {
            isValid = false;
            return isValid;
        }
        list.add(p.val);
        if (p.right != null) {
            isValid = DFS(p.right, list);
        }
        return isValid;
    }


}
