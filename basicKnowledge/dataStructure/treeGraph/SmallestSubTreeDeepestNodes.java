package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 * <p>
 * 执行结果：
 * 通过
 */
public class SmallestSubTreeDeepestNodes {
    Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 广度优先遍历找到该子树
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        DFS(root, 0);
        int H = map.get(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null && map.get(node) == H) {
                return node;
            }
            if (node.left != null && node.right != null && map.get(node.left) == map.get(node.right)) {
                return node;
            }
            if (node.left != null) {
                if (map.get(node.left) == H) {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (map.get(node.right) == H) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    //获取每个节点的子树最大深度
    int DFS(TreeNode node, int h) {
        int l = 0, r = 0;
        if (node == null) {
            return 0;
        }
        if (node.left != null) {
            l = DFS(node.left, h + 1);
        }
        if (node.right != null) {
            r = DFS(node.right, h + 1);
        }
        if (l + r == 0) {
            map.put(node, h);
            return h;
        } else {
            map.put(node, (l > r ? l : r));
            return map.get(node);
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
