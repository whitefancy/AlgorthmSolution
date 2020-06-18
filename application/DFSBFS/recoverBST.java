package OJSolution.application.DFSBFS;

import OJSolution.datastructure.TreeNode;
import OJSolution.tool.BinaryTreeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树
 */
public class recoverBST {
    public static void main(String[] args) {
        TreeNode treeNode = BinaryTreeBuilder.buildByString("3,1,4,null,null,2");
        new recoverBST().recoverTree(treeNode);
        System.out.println(BinaryTreeBuilder.tree2ArrayString(treeNode, 6));
    }

    /**
     * 中序遍历找到第一个错误的，中序逆遍历找到第二个错误的，然后交换。
     *
     * @param root
     */
    private void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        TreeNode[] ans = new TreeNode[2];
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).val > list.get(i).val) {
                ans[0] = list.get(i - 1);
            }
        }
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i - 1).val > list.get(i).val) {
                ans[1] = list.get(i);
            }
        }
        int t = ans[0].val;
        ans[0].val = ans[1].val;
        ans[1].val = t;
    }

    private void inorder(TreeNode p, List<TreeNode> list) {
        if (p.left != null) {
            inorder(p.left, list);
        }
        list.add(p);
        if (p.right != null) {
            inorder(p.right, list);
        }
    }
}
