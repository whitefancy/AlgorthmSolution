package Algorithm.basicKnowledge.dataStructure.treeGraph.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 执行结果：
 * 通过
 */
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Deque<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            queue.offer(null);
        }
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                ans.add(list);
                list = new LinkedList<>();
                queue.offer(null);
                root = queue.poll();
                if (root == null) {
                    break;
                }
            }
            list.add(root.val);
            for (Node child : root.children) {
                queue.offer(child);
            }
        }
        return ans;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
