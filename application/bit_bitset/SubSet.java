package OJSolution.application.bit_bitset;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};
        new SubSet().subsets(A);
    }

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集
     * bwftag 位运算 穷举
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int m = (int) Math.pow(2, n) - 1;
        List<List<Integer>> lists = new ArrayList<>(m);
        for (int i = 0; i <= m; i++) {
            char[] chars = Integer.toBinaryString(i).toCharArray();
            List<Integer> list = new ArrayList<>(nums.length);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    list.add(nums[chars.length - 1 - j]);//因为高位在前
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
