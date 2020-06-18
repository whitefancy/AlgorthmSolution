package OJSolution.application.heap_priorityqueue;

import java.util.*;

public class TopK {
    /**
     * 输出数组的topK元素列表
     * *bwftag  堆排序 状态ok
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        queue.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

}
