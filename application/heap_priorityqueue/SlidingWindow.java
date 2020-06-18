package OJSolution.application.heap_priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] A;
        A = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        new SlidingWindow().maxSlidingWindow(A, 3);
    }

    private int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
        int[] ans = null;
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }
        ans = new int[nums.length - k + 1];
        int j = 0;
        for (int i = k - 1; i < nums.length; i++) {
            queue.offer(nums[i]);
            ans[j] = queue.peek();
            queue.remove(nums[j]);
            j++;
        }
        return ans;
    }
}
