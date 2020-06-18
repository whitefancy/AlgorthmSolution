package Algorithm.basicKnowledge.dataStructure.treeGraph.DFS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计算树的最大宽度 所有的顶点连线中，边最多的那个的边数量
 * 线程安全的写法
 */
public class WidthOfBTree {
    volatile Integer max = 0;
    ThreadLocal<Integer> max2 = ThreadLocal.withInitial(() -> new Integer(0));
    AtomicInteger max3 = new AtomicInteger(0);

    //求结果
    int CalMaxDis(Node root) {
        if (root == null) {
            return 0;
        }
        //第一种 synchronized关键字
        CalMaxDis1(root);
        System.out.println(max);
        //第二种，局部变量
        int[] max1 = new int[1];
        CalMaxDis2(root, max1);
        System.out.println(max1[0]);
        //第三种 ThreadLocal变量
        CalMaxDis3(root);
        System.out.println(max2.get());
        //第四种 使用原子类
        CalMaxDis4(root);
        System.out.println(max3.intValue());
        return max;
    }

    // 计算子树的最大深度
    int CalMaxDis1(Node root) {  //
        if (root == null) {
            return 0;
        }
        int left = CalMaxDis1(root.left);
        int right = CalMaxDis1(root.right);
        int temp = left + right;
        synchronized (max) {
            if (temp > max) {
                max = temp;
            }
        }
        return Math.max(left, right) + 1;
    }

    // 计算子树的最大深度
    int CalMaxDis2(Node root, int[] max1) {  //
        if (root == null) {
            return 0;
        }
        int left = CalMaxDis1(root.left);
        int right = CalMaxDis1(root.right);
        int temp = left + right;
        synchronized (max1) {
            if (temp > max1[0]) {
                max1[0] = temp;
            }
        }
        return Math.max(left, right) + 1;
    }

    // 计算子树的最大深度
    int CalMaxDis3(Node root) {  //
        if (root == null) {
            return 0;
        }
        int left = CalMaxDis1(root.left);
        int right = CalMaxDis1(root.right);
        int temp = left + right;
        if (temp > max2.get()) {
            max2.set(temp);
        }
        return Math.max(left, right) + 1;
    }

    // 计算子树的最大深度
    int CalMaxDis4(Node root) {  //
        if (root == null) {
            return 0;
        }
        int left = CalMaxDis1(root.left);
        int right = CalMaxDis1(root.right);
        int temp = left + right;
        max3.updateAndGet(x -> Math.max(x, temp));
        return Math.max(left, right) + 1;
    }

    class Node {
        Node left;
        Node right;
    }
}
