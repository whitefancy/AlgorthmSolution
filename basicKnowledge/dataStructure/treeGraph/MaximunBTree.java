package Algorithm.basicKnowledge.dataStructure.treeGraph;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * 执行结果：
 * 通过
 */
public class MaximunBTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMBT(0, nums.length, nums);
    }

    TreeNode constructMBT(int lind, int rind, int[] nums) {
        if (lind == rind) {
            return null;
        }
        int mind = lind;
        int max = nums[lind];
        for (int i = lind; i < rind; i++) {
            if (nums[i] > max) {
                mind = i;
                max = nums[i];
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMBT(lind, mind, nums);
        node.right = constructMBT(mind + 1, rind, nums);
        return node;
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
