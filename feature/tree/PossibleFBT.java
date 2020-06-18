package OJSolution.feature.tree;

import OJSolution.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定N个节点，输出所有的满二叉树
 */
public class PossibleFBT {
    /**
     * 给定N个节点，输出所有的满二叉树
     * bwftag 二叉树 一般特性 状态失败
     *
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {
        TreeNode root = new TreeNode(0);
        List<TreeNode> list = new LinkedList<>();
        if (N % 2 == 0) {
            return list;
        }
        int i = 1;
        while (i < N) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int n = queue.size();
            while (n > 0) {
                TreeNode cur = queue.poll();

            }
        }
        return list;
    }

}
