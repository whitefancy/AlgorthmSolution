package OJSolution.application.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> list = new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> ll : list) {
            for (Integer in : ll) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * bwftag  组合数学 有放回抽取中满足某个条件的全部组合 回溯 状态ok
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        int n = candidates.length;
        if (n < 1) {
            return list;
        }
        if (target < 1) {
            list.add(new ArrayList<>());
            return list;
        }
        Arrays.sort(candidates);
        int[] ans = new int[target];
        backTracking(list, ans, candidates, target, 0, 0, 0);
        return list;
    }

    private void backTracking(List<List<Integer>> list, int[] ans,
                              int[] candidates, int target, int count, int now, int end) {
        if (count == target) {
            list.add(Arrays.stream(ans).boxed().limit(end).collect(Collectors.toList()));
            return;
        }
        for (int i = now; i < candidates.length; i++) {
            ans[end] = candidates[i];
            if (count + candidates[i] > target) {
                break;
            }
            backTracking(list, ans, candidates, target, count + candidates[i], i, end + 1);
        }
    }

}