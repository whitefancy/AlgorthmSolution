package OJSolution.unsolve;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
class Solution {
    int longest;

    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        longest = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (longest < i) {
                return false;
            } else if (longest >= nums.length) {
                return true;
            }
            int temp = nums[i] + i;
            if (temp > longest) {
                longest = temp;
            }
        }
        return true;
    }
}