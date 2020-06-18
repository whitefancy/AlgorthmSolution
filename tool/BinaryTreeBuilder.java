package OJSolution.tool;

import OJSolution.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BinaryTreeBuilder {
    private static String[] nodes;
    private static Integer[] vals;
    private static int n;
    private static TreeNode root;

    /**
     * bwftag 二叉树 工具 状态ok
     *
     * @param vals 3,1,4,null,null,2
     * @return
     */
    public static TreeNode buildByArray(Integer[] vals) {
        if (vals.length == 0) {
            return BinaryTreeBuilder.root;
        }
        int val = vals[0];
        BinaryTreeBuilder.root = new TreeNode(val);
        BinaryTreeBuilder.creatTree(0, BinaryTreeBuilder.root);
        return BinaryTreeBuilder.root;
    }

    /**
     * bwftag 二叉树 工具 状态ok
     *
     * @param s 3,1,4,null,null,2
     * @return
     */
    public static TreeNode buildByString(String s) {
        if (s.equals("")) {
            return BinaryTreeBuilder.root;
        }
        BinaryTreeBuilder.nodes = s.split(",");
        BinaryTreeBuilder.n = BinaryTreeBuilder.nodes.length;
        int val = Integer.valueOf(BinaryTreeBuilder.nodes[0]);
        BinaryTreeBuilder.root = new TreeNode(val);
        BinaryTreeBuilder.creatTree(0, BinaryTreeBuilder.root);
        return BinaryTreeBuilder.root;
    }

    private static void creatTreeByVals(int i, TreeNode cur) {
        int k = 2 * i + 1;
        if (k < BinaryTreeBuilder.n && BinaryTreeBuilder.vals[k] != null) {
            int val = BinaryTreeBuilder.vals[k];
            TreeNode node = new TreeNode(val);
            cur.left = node;
            BinaryTreeBuilder.creatTree(k, node);
        }
        k++;
        if (k < BinaryTreeBuilder.n && BinaryTreeBuilder.vals[k] != null) {
            int val = BinaryTreeBuilder.vals[k];
            TreeNode node = new TreeNode(val);
            cur.right = node;
            BinaryTreeBuilder.creatTree(k, node);
        }
    }

    private static void creatTree(int i, TreeNode cur) {
        int k = 2 * i + 1;
        if (k < BinaryTreeBuilder.n && !BinaryTreeBuilder.nodes[k].equals("null")) {
            int val = Integer.valueOf(BinaryTreeBuilder.nodes[k]);
            TreeNode node = new TreeNode(val);
            cur.left = node;
            BinaryTreeBuilder.creatTree(k, node);
        }
        k++;
        if (k < BinaryTreeBuilder.n && !BinaryTreeBuilder.nodes[k].equals("null")) {
            int val = Integer.valueOf(BinaryTreeBuilder.nodes[k]);
            TreeNode node = new TreeNode(val);
            cur.right = node;
            BinaryTreeBuilder.creatTree(k, node);
        }
    }

    /**
     * bwftag 二叉树 工具 状态ok
     *
     * @param root
     * @param len
     * @return
     */
    private static Integer[] tree2Array(TreeNode root, int len) {
        if (len <= 0) {
            return null;
        }
        Integer[] list = new Integer[len];
        int i = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return list;
        }
        BinaryTreeBuilder.inOrder(root, list, 0);
        return list;
    }

    private static void inOrder(TreeNode root, Integer[] list, int i) {
        list[i] = root.val;
        if (root.left != null) {
            BinaryTreeBuilder.inOrder(root.left, list, 2 * i + 1);
        }
        if (root.right != null) {
            BinaryTreeBuilder.inOrder(root.right, list, 2 * i + 2);
        }
    }

    /**
     * bwftag 二叉树 工具 状态ok
     *
     * @param root
     * @param len
     * @return
     */
    public static String tree2ArrayString(TreeNode root, int len) {
        return Arrays.deepToString(BinaryTreeBuilder.tree2Array(root, len));
    }
}
