package Algorithm.basicKnowledge.dataStructure.treeGraph;

/**
 * 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubtreeOfAnotherTree {
    /**
     * 看到题目描述，首先判断一个树是否是另一棵树的子树，很明显想到可以用递归，但是两棵树完全相同也可以看做一棵树是另一棵树的子树。
     * 所以自然而然想到用一个判断两棵树是否相同的递归函数。
     * <p>
     * 作者：kelly2018
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree/solution/java-di-gui-ban-by-kelly2018/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 执行结果：
     * 通过
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
