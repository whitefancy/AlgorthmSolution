package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 执行结果：
 * 通过
 */
public class PathSumOfTree {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        DFS(root, 0, sum, new LinkedList<>());
        return res;
    }

    /**
     * 我们使用List<TreeNode>来存储，浪费内存还慢
     * 对于只输出值的，可以用List<Integer>存储
     * * 执行结果：
     * * 通过
     *
     * @param node
     * @param count
     * @param sum
     * @param list
     */
    void DFS1(TreeNode node, int count, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        count += node.val;
        if (node.left == null && node.right == null) {
            if (count == sum) {
                //这里需要将数组复制出来
                //这里退出之前不要忘了remove节点
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        } else {
            DFS1(node.left, count, sum, list);
            DFS1(node.right, count, sum, list);
        }
        count = count - node.val;
        list.remove(list.size() - 1);
        return;
    }

    /**
     * * 执行结果：
     * * 通过
     *
     * @param node
     * @param count
     * @param sum
     * @param list
     */
    void DFS(TreeNode node, int count, int sum, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        count += node.val;
        if (node.left == null && node.right == null) {
            if (count == sum) {
                //这里需要将数组复制出来
                List<Integer> list1 = new ArrayList<>(list.size());
                for (TreeNode tn : list) {
                    list1.add(tn.val);
                }
                //这里退出之前不要忘了remove节点
                res.add(list1);
                list.remove(list.size() - 1);
                return;
            }
        } else {
            DFS(node.left, count, sum, list);
            DFS(node.right, count, sum, list);
        }
        count = count - node.val;
        list.remove(list.size() - 1);
        return;
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
