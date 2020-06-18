package Algorithm.basicKnowledge.dataStructure.Array;

/**
 * 乘积小于K的子数组
 * 给定一个正整数数组 nums。
 * <p>
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */
public class SubarrayProductLessThanK {
    /**
     * 超时
     */
    int ans = 0;

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            track(nums, k, i, 1, n);
        }
        return ans;
    }

    void track(int[] nums, int k, int l, int p, int n) {
        if (l >= n) {
            return;
        }
        p = p * nums[l];
        if (p >= k) {
            return;
        }
        ans++;
        track(nums, k, l + 1, p, n);
    }

    /*
    方法二：双指针
分析

对于每个 \mathrm{right}right，我们需要找到最小的 \mathrm{left}left，满足 \prod_{i=\mathrm{left}}^\mathrm{right} \mathrm{nums}[i] < k∏
i=left
right
​
 nums[i]<k。由于当 \mathrm{left}left 增加时，这个乘积是单调不增的，因此我们可以使用双指针的方法，单调地移动 \mathrm{left}left。

算法

我们使用一重循环枚举 \mathrm{right}right，同时设置 \mathrm{left}left 的初始值为 0。在循环的每一步中，表示 \mathrm{right}right 向右移动了一位，将乘积乘以 \mathrm{nums}[\mathrm{right}]nums[right]。此时我们需要向右移动 \mathrm{left}left，直到满足乘积小于 kk 的条件。在每次移动时，需要将乘积除以 \mathrm{nums}[\mathrm{left}]nums[left]。当 \mathrm{left}left 移动完成后，对于当前的 \mathrm{right}right，就包含了 \mathrm{right} - \mathrm{left} + 1right−left+1 个乘积小于 kk 的连续子数组。

     */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int pro = 1;
        if (k <= 1) {
            return 0;
        }
        while (right < n) {
            pro = pro * nums[right];
            while (pro >= k) {
                pro = pro / nums[left];
                left++;
            }
            ans = ans + right - left + 1;
            right++;
        }
        return ans;
    }
}
