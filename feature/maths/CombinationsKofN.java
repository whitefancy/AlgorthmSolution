package OJSolution.feature.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class CombinationsKofN {
    public static void main(String[] args) {
        List<List<Integer>> list = new CombinationsKofN().combine(4, 2);
        for (List<Integer> l : list) {
            for (Integer num : l) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 不是排列，而是组合，从n个数中选k个数，可以选出来哪些？
     * bwftag  组合数学 C_n_k全部的组合情况 回溯 状态ok
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        if (n < 1) {
            return list;
        }
        if (k < 1) {
            list.add(new ArrayList<>());
            return list;
        }
        int[] ans = new int[k];
        backTracking(list, ans, k, n, 0, 0);
        return list;
    }

    private void backTracking(List<List<Integer>> list, int[] ans, int k, int n, int first, int now) {
        if (first == k) {
            list.add(Arrays.stream(ans).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = now; i < n; i++) {
            ans[first] = i + 1;
            backTracking(list, ans, k, n, first + 1, i + 1);
        }
    }
}