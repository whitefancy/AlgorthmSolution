package Algorithm.basicKnowledge.dataStructure.Array;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProductSubarray {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cmax = 1;
        int cmin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = cmax;
                cmax = cmin;
                cmin = temp;
            }
            cmax = Math.max(cmax * nums[i], nums[i]);
            cmin = Math.min(cmin * nums[i], nums[i]);
            if (cmax > max) {
                max = cmax;
            }
        }
        return max;
    }
}
