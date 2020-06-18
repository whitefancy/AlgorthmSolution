package Algorithm.basicKnowledge.Algothrom.Search;

/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    /**
     * 通过
     *
     * @param nums
     * @param l
     * @param r
     * @param t
     * @return
     */
    int search(int[] nums, int l, int r, int t) {
        int m = (l + r) / 2;
        if (nums[m] == t) {
            return m;
        }
        if (l == r) {
            return -1;
        }
        if (nums[m] > t) {
            return search(nums, l, m, t);
        }
        if (nums[m] < t) {
            return search(nums, m + 1, r, t);
        }
        return -1;
    }
}
