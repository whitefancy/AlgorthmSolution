package OJSolution.feature.tree;

import OJSolution.datastructure.TreeNode;
import OJSolution.tool.BinaryTreeBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断两棵树是不是翻转等价的。
 * bwftag 二叉树 一般特性 状态未知
 */
public class FlipEquivTree {
    // 判断两棵树是不是翻转等价的。
    private Map<Integer, Set<Integer>> tree1;
    private Map<Integer, Set<Integer>> tree2;

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            if (root1 == null && root2 == null) {
                return true;
            } else {
                return false;
            }
        }
        tree1 = new HashMap<>();
        tree2 = new HashMap<>();
        preOrderTraverse(root1, tree1);
        preOrderTraverse(root2, tree2);
        String s1 = tree1.toString();
        String s2 = tree2.toString();
        if (tree1.equals(tree2)) //if(s1.equals(s2))
        {
            return true;
        } else {
            return false;
        }

    }

    private void preOrderTraverse(TreeNode root, Map<Integer, Set<Integer>> tree) {
        Set<Integer> set = new HashSet<>();
        if (root.left != null) {
            set.add(root.left.val);
            preOrderTraverse(root.left, tree);
        }
        if (root.right != null) {
            set.add(root.right.val);
            preOrderTraverse(root.right, tree);
        }
        tree.put(root.val, set);
    }

    private boolean flipEquiv1(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv1(root1.left, root2.left) && flipEquiv1(root1.right, root2.right)) || (flipEquiv1(root1.left, root2.right) && flipEquiv1(root1.right, root2.left));
    }

    public void test() {
        String A = "0,3,1,5,4,14,2,30,16,null,10,null,null,13,6,41,34,null,null,null,11,null,17,8,7,null,null,39,null,18,12,36,20,23,9,19,26,null,null,22,null,null,null,null,null,46,37,24,40,31,15,21,38,42,null,25,33,null,null,47,null,29,null,48,null,null,null,28,32,27,null,null,null,43,null,null,null,null,null,null,null,null,null,null,null,35,null,null,null,null,null,45,44,null,49";
        String B = "0,1,3,2,14,4,5,6,13,null,null,null,10,30,16,8,7,null,17,null,11,34,41,null,null,23,9,19,26,36,20,18,12,null,39,null,null,40,24,15,31,38,21,42,null,null,null,46,37,null,22,null,null,null,null,48,null,29,null,32,28,null,null,null,null,27,null,43,null,null,null,47,null,33,25,null,null,null,null,null,null,35,null,null,null,44,45,null,null,null,null,null,null,null,49";
        TreeNode root1 = BinaryTreeBuilder.buildByString(A);
        TreeNode root2 = BinaryTreeBuilder.buildByString(A);
        System.out.println(flipEquiv1(root1, root2));
    }
}
