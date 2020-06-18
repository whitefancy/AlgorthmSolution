package Algorithm.basicKnowledge.dataStructure.treeGraph;

import java.util.ArrayDeque;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 执行结果：
 * 通过
 */
public class SerializeAndSeserializeBST1 {

    /**
     * 二叉搜索树能只够通过前序序列或后序序列构造，是因为以下两个因素：
     * <p>
     * 二叉树可以通过前序序列或后序序列和中序序列构造。
     * 二叉搜索树的中序序列是递增排序的序列，inorder = sorted(preorder)。
     * 说明我们只需要直到了前序序列或后序序列相当于我们也知道了中序序列，可以通过排序获得。
     * <p>
     * /
     * <p>
     * /*
     * 方法二可以在不使用分隔符的情况下完成工作。
     * 因为所有节点的值为 4 个字节，因此我们可以把编码序列 4 个字节当作一个块，将每个块转换为整数，因此可以不使用分隔符。
     */
// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = postOrder(root, new StringBuilder());
        //sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    StringBuilder postOrder(TreeNode node, StringBuilder sb) {
        if (node.left != null) {
            postOrder(node.left, sb);
        }
        if (node.right != null) {
            postOrder(node.right, sb);
        }
        sb.append(intToString(node.val));
        return sb;
    }

    /*
    方法二可以在不使用分隔符的情况下完成工作。
    因为所有节点的值为 4 个字节，因此我们可以把编码序列 4 个字节当作一个块，将每个块转换为整数，因此可以不使用分隔符。

     */
    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
        int result = 0;
        for (char b : bytesStr.toCharArray()) {
            result = (result << 8) + (int) b;
        }
        return result;
    }

    // Encodes integer to bytes string
    public String intToString(int x) {
        char[] bytes = new char[4];
        for (int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < data.length() / 4; i++) {
            stack.offerLast(stringToInt(data.substring(i * 4, i * 4 + 4)));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    TreeNode helper(int lower, int upper, ArrayDeque<Integer> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        Integer val = stack.peekLast();
        if (val < lower || val > upper) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        stack.pollLast();
        node.right = helper(val, upper, stack);
        node.left = helper(lower, val, stack);
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
