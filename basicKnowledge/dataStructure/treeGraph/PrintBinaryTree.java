package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * <p>
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * <p>
 * 创建一个长度为 height\times(2^{height}-1)height×(2
 * height
 * −1) 的数组 resres，其中 heightheight 是树的高度。先使用空字符串 "" 填充数组 resres。然后递归调用 fill(res, root, i, l, r) 将节点的值输出到数组 resres 中，其中 ii 表示当前节点所在层数，ll 和 rr 表示当前子树在数组 resres 中的左右边界，当前节点被输出到数组 resres 第 ii 行的第 ll 列和第 rr 列中间位置上。
 * 执行结果：
 * 通过
 */
public class PrintBinaryTree {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        int H = DFS(root);
        int W = (int) Math.pow(2, H) - 1;
        for (int i = 0; i < H; i++) {
            List<String> list = new ArrayList<>(W);
            for (int j = 0; j < W; j++) {
                list.add("");
            }
            ans.add(list);
        }
        Output(root, 0, W, 0);
        return ans;
    }

    int DFS(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 0, right = 0;
        left = DFS(node.left);
        right = DFS(node.right);
        int h = 1 + (left > right ? left : right);
        return h;
    }

    void Output(TreeNode node, int lind, int rind, int h) {
        if (node == null) {
            return;
        }
        List<String> list = ans.get(h);
        list.set((lind + rind) / 2, "" + node.val);
        Output(node.left, lind, (lind + rind) / 2, h + 1);
        Output(node.right, (lind + rind) / 2 + 1, rind, h + 1);
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
