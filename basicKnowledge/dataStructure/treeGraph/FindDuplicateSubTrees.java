package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * 执行结果：
 * 通过
 */
public class FindDuplicateSubTrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        SerializeTree(root);
        return ans;
    }

    /**
     * 序列化树
     *
     * @param node
     * @return
     */
    String SerializeTree(TreeNode node) {
        if (null == node) {
            return "" + '#';
        }
        String s = node.val + "," + SerializeTree(node.left) + "," + SerializeTree(node.right);
        if (map.containsKey(s)) {
            map.compute(s, (key, value) -> (Integer) value + 1);
            if (map.get(s) == 2) {
                ans.add(node);
            }
        } else {
            map.put(s, 1);
        }
        return s;
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
