package Algorithm.basicKnowledge.dataStructure.treeGraph;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 执行结果：
 * 通过
 */
public class rebuildBTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * 递归
     *
     * @param pleft
     * @param pright
     * @param ileft
     * @param iright
     * @param preorder
     * @param inorder
     * @return
     */
    TreeNode buildTree(int pleft, int pright, int ileft, int iright, int[] preorder, int[] inorder) {
        if (pright < pleft) {
            return null;
        }
        if (iright < ileft) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pleft]);
        for (int i = 0; i <= iright - ileft; i++) {
            if (inorder[ileft + i] == preorder[pleft]) {
                if (i != 0) {
                    root.left = buildTree(pleft + 1, pleft + i, ileft, ileft + i - 1, preorder, inorder);
                }
                if (i != iright - ileft) {
                    root.right = buildTree(pleft + i + 1, pright, ileft + i + 1, iright, preorder, inorder);
                }

            }
        }
        return root;
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
