package OJSolution.application.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class CombinationSum9 {
    public static void main(String[] args) {
        List<List<Integer>> list = new CombinationSum9().combinationSum3(3, 9);
        for (List<Integer> ll : list) {
            for (Integer in : ll) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }

    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字
     * <p>
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * bwftag  组合数学 C_n_k全部的组合情况中满足某个条件的全部组合 回溯 状态ok
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new LinkedList<>();
        if (n < 1) {
            return list;
        }
        if (k < 1) {
            list.add(new ArrayList<>());
            return list;
        }
        int[] ans = new int[k];
        backTracking(list, ans, k, n, 0, 0, 0);
        return list;
    }

    private void backTracking(List<List<Integer>> list, int[] ans, int k, int n, int count, int first, int now) {
        if (first == k) {
            if (count == n) {
                list.add(Arrays.stream(ans).boxed().collect(Collectors.toList()));
            }
            return;
        }
        for (int i = now; i < 9; i++) {
            ans[first] = i + 1;
            if (count + i + 1 > n) {
                break;
            }
            backTracking(list, ans, k, n, count + i + 1, first + 1, i + 1);
        }
    }
}