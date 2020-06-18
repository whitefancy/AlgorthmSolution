package OJSolution.application.heap_priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindEleInHeap {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] A1 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] A2 = new int[]{3, 2, 1, 5, 6, 4};
        new FindEleInHeap().findKthLargest(A, 1);
        System.out.println(new FindEleInHeap().findKthLargest(A, 1));//8
        System.out.println(new FindEleInHeap().findKthLargest(A, 3));//6
        System.out.println(new FindEleInHeap().findKthLargest(A, 4));//5
        System.out.println(new FindEleInHeap().findKthLargest(A, 7));//2
        System.out.println(new FindEleInHeap().findKthLargest(A1, 4));//4
        System.out.println(new FindEleInHeap().findKthLargest(A2, 2));//5
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是第 k 个不同的元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int min = set.first();
            int max = set.last();
            int p = nums[i];
            if (p > min) {
                set.remove(min);
                set.add(p);
            }
        }
        return set.first();
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest(int[] nums, int k) {
        Comparator<Integer> Order = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue(k, Order);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
