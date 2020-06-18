package OJSolution.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 MajorityChecker 的类，它应该具有下述几个 API：
 * <p>
 * MajorityChecker(int[] arr) 会用给定的数组 arr 来构造一个 MajorityChecker 的实例。
 * int query(int left, int right, int threshold) 有这么几个参数：
 * 0 <= left <= right < arr.length 表示数组 arr 的子数组的长度。
 * 2 * threshold > right - left + 1，也就是说阀值 threshold 始终比子序列长度的一半还要大。
 * 每次查询 query(...) 会返回在 arr[left], arr[left+1], ..., arr[right] 中至少出现阀值次数 threshold 的元素，如果不存在这样的元素，就返回 -1。
 * *bwftag  阈值 数据结构 超半数 状态ok
 */
class MajorityChecker {
    private int[] arr;
    private Map<Integer, Integer> times = new HashMap<>();
    private int[] repeats;

    MajorityChecker(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        repeats = new int[n];
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int value = times.getOrDefault(key, 0);
            repeats[i] = value;
            times.put(key, value + 1);
        }
        times = null;
    }

    int query(int left, int right, int threshold) {
        int m = (right - left) / 2;
        for (int i = left; i < right; i++) {
            for (int j = right; j >= left; j--) {
                if (arr[i] == arr[j] && (repeats[j] - repeats[i] + 1 >= threshold)) {
                    return arr[i];
                }
                if (j - i - 1 < m) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
