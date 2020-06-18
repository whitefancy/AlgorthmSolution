package OJSolution.feature.tree;

import OJSolution.datastructure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * bwftag 链表 一般特性 状态未知
 */
public class FindSecondMinValue {
    /**
     * 找到二叉树中第二小的值
     * bwftag 二叉树 无向图 一般特性 状态未知
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> vals = new LinkedList<>();
        list.add(root);
        vals.add(root.val);
        while (!list.isEmpty()) {
            TreeNode cur = list.poll();
            if (cur.val > min) {
                vals.add(cur.val);
            }
            if (cur.left != null) {
                if (cur.left.val <= cur.right.val) {
                    list.add(cur.left);
                    list.add(cur.right);
                } else {
                    list.add(cur.right);
                    list.add(cur.left);
                }
            }
        }
        Collections.sort(vals);
        for (Integer i : vals) {
            if (i > min) {
                return i;
            }
        }
        return -1;
    }
}
