package Algorithm.basicKnowledge.dataStructure.treeGraph;

/**
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * <p>
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * <p>
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * <p>
 * 执行结果：
 * 通过
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        countChild(root);
        return root;
    }

    /**
     * 递归统计子节点的和
     * 不满足则释放左子树或右子树
     * 不能直接释放node节点，因为是局部变量，会无效
     *
     * @param node
     * @return
     */
    int countChild(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = 0;
        int r = 0;
        if (node.left != null) {
            l = countChild(node.left);
            if (l == 0) {
                node.left = null;
            }
        }
        if (node.right != null) {
            r = countChild(node.right);
            if (r == 0) {
                node.right = null;
            }
        }
        if (l + r + node.val == 0) {
            return 0;
        } else {
            return l + r + node.val;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
