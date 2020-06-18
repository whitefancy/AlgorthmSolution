package OJSolution.application.sort;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * *bwftag  计数排序 状态ok
 */
public class OnePass {
    private void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int k = nums.length - 1;
        int s = 0;
        for (int i = 0; i < nums.length; ) {
            int a = nums[i];
            if (a == 0) {
                for (int i1 = i; i1 > 0; i1--) {
                    nums[i1] = nums[i1 - 1];
                }
                nums[0] = 0;
                i++;
            } else if (a == 2) {
                if (i + s > k) {
                    break;
                }
                for (int i1 = i; i1 < k; i1++) {
                    nums[i1] = nums[i1 + 1];
                }
                nums[k] = 2;
                s++;
            } else {
                i++;
            }
        }
        System.out.println(nums);
    }

    public void test() {
        int[] a = new int[]{0, 0};
        sortColors(a);
    }
}
