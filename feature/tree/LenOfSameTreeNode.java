package OJSolution.feature.tree;

import OJSolution.datastructure.TreeNode;

public class LenOfSameTreeNode {
    int max = 1;

    public static void main(String[] args) {
        TreeNode root = null;
        LenOfSameTreeNode lenOfSameTreeNode1 = new LenOfSameTreeNode();
        lenOfSameTreeNode1.preOrder(root, 0);
        System.out.println(lenOfSameTreeNode1.max);
    }

    /**
     * 查找父子相同的节点的最大重复个数
     * 已解决
     *
     * @param root
     * @param count
     * @return
     */
    public int preOrder(TreeNode root, int count) {
        int temp = count;
        if (temp > max) {
            max = temp;
        }
        if (root.left != null && root.val == root.left.val) {
            temp = preOrder(root.left, count + 1);
        }
        if (root.left != null && root.val != root.left.val) {
            temp = preOrder(root.left, 1);
        }
        if (root.right != null && root.val == root.left.val) {
            temp = preOrder(root.right, count + 1);
        }
        if (root.right != null && root.val != root.left.val) {
            temp = preOrder(root.right, 1);
        }
        return 0;
    }
}
