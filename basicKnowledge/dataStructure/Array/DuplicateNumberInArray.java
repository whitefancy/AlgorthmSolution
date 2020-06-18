package Algorithm.basicKnowledge.dataStructure.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * 执行结果：
 * 通过
 */
public class DuplicateNumberInArray {
    /**
     * 解法一 hashmap
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //putIfAbsent不存在返回 null， 存在返回旧的值
            if (null != map.putIfAbsent(nums[i], Boolean.TRUE)) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 解法二 交换元素 内存复杂度O(1)
     * 执行结果：
     * 通过
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return 0;
    }
}
