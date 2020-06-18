package OJSolution.application.heap_priorityqueue;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * <p>
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 */
public class FindPairs {
    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 11};
        int[] b = new int[]{2, 4, 6};
        new FindPairs().kSmallestPairs(a, b, 3);
    }

    private List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new LinkedList<>();
        Comparator<Pair<Integer, Integer>> order = new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return (o1.getKey() + o1.getValue()) - (o2.getKey() + o2.getValue());
            }
        };
        if (k <= 0) {
            return list;
        }
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(k * k, order);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair<>(nums1[i], nums2[j]));
                if (j == k) {
                    continue;
                }
            }
            if (i == k) {
                continue;
            }
        }
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                Pair<Integer, Integer> pair = queue.poll();
                List<Integer> list1 = new ArrayList<>(2);
                list1.add(pair.getKey());
                list1.add(pair.getValue());
                list.add(list1);
            }
        }
        return list;
    }
}
