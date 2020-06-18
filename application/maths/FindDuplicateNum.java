package OJSolution.application.maths;


public class FindDuplicateNum {
    int[] nums;

    public static void main(String[] args) {
        FindDuplicateNum h = new FindDuplicateNum();
        int a = h.findMost();
    }

    /**
     * 查找重复个数超过一半的那个数字
     * 已解决
     *
     * @return
     */
    private int findMost() {
        int a = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (a != nums[i]) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                a = nums[i + 1];
            }
        }
        return a;
    }
}
