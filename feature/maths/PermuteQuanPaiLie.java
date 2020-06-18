package OJSolution.feature.maths;

import java.util.*;
import java.util.stream.Collectors;

class PermuteQuanPaiLie {
    public static void main(String[] args) {
        List<List<Integer>> list = new PermuteQuanPaiLie().permute(new int[]{1, 2, 3, 4});
        for (List<Integer> list1 : list) {
            for (Integer integer : list1) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * 依次用第一个元素跟后面的元素交换，得到全排列
     * bwftag  组合数学 全排列 回溯 状态ok
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums.length < 1) {
            list.add(new ArrayList<>());
            return list;
        }
        List<Integer> ans = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backTracking(list, nums.length, 0, ans);
        return list;
    }

    private void backTracking(List<List<Integer>> list, int length, int k, List<Integer> ans) {
        if (k == length - 1) {
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = k; i < length; i++) {
            Collections.swap(ans, k, i);
            backTracking(list, length, k + 1, ans);
            Collections.swap(ans, k, i);
        }
    }
}