package OJSolution.application.bit_bitset;

public class RepeatNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(n ^= 0);
        System.out.println(n ^= n);
        int[] A = new int[]{-2, -2, 1, 1, -3, 1, -3, -3, -4, -2};
        n = new RepeatNumber().singleNumber(A);
        System.out.println(n);
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 异或运算^=
     * bwftag 位运算
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum ^= nums[i];//数字跟自己异或等于0
            // 数字跟0异或等于其本身
        }
        return sum;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
     * 找出那个只出现了一次的元素
     * bwftag 位运算
     *
     * @param nums
     * @return
     */
    private int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        /*
        这个算法可以用于负数。
         */
        int[] array = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j] >> i;
                array[i] += num & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            int k = array[i] % 3;
            ans += k << i;
        }
        return ans;
    }
}
