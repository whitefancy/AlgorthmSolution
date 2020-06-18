package Algorithm.basicKnowledge.dataStructure.Array;

public class ProductOfArrayExceptSelf {
    /**
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * <p>
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。
     * <p>
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * <p>
     * 执行结果：
     * 通过
     * 每个位置的结果，即为它左边的数的乘积，乘上它右边的数的乘积。
     * 因此，我们只要申请两个数组，一个用来记录每个位置左边的乘积，和它右边的乘积，再把两个数组乘起来即可。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i];
        }
        int a = nums[n - 1];
        ans[n - 1] = ans[n - 2];
        for (int i = n - 2; i > 0; i--) {
            ans[i] = ans[i - 1] * a;
            a = a * nums[i];
        }
        ans[0] = a;
        return ans;
    }
}
