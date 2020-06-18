package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * 输出：[7,4,1]
 * <p>
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * 执行结果：
 * 通过
 */
public class AllNodesDistKinBTree {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    /**
     * 使用图的广度优先遍历寻找距离为k的节点
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        DFS(root, null);
        //BFS check distance;
        int k = -1;
        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        set.add(target);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (k == K) {
                    ans.add(node.val);
                } else {
                    List<TreeNode> list = map.get(node);
                    for (TreeNode tn : list) {
                        if (!set.contains(tn)) {
                            queue.offer(tn);
                            set.add(tn);
                        }
                    }
                }
            } else {
                k++;
                queue.offer(null);
                if (k > K) {
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 将树转换成图
     *
     * @param node
     * @param parent
     */
    void DFS(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>(3);
        if (parent != null) {
            list.add(parent);
        }
        if (node.left != null) {
            list.add(node.left);
            DFS(node.left, node);
        }
        if (node.right != null) {
            list.add(node.right);
            DFS(node.right, node);
        }
        map.put(node, list);
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
