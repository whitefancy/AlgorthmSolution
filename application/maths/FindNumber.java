package OJSolution.application.maths;

import java.util.ArrayList;

public class FindNumber {
    public void test() {
        int[] A = new int[]{-2, 0, -1};
        // System.out.println(majorityElement(A));
        System.out.println(maxProduct(A));
    }

    public int majorityElement(int[] nums) {
//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在众数。
//从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个 可以用数学归纳法证明
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

    private int maxProduct(int[] nums) {
//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//输入: [2,3,-2,4] 输出: 6 解释: 子数组 [2,3] 有最大乘积 6
//思路： 求最大值，可以看成求被0拆分的各个子数组的最大值。
//当一个数组中没有0存在，则分为两种情况：
//1.负数为偶数个，则整个数组的各个值相乘为最大值；
//2.负数为奇数个，则从左边开始，乘到最后一个负数停止有一个“最大值”，从右边也有一个“最大值”，比较，得出最大值。
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        int negNum = 0, sNum = 0;
        ArrayList<Integer> info = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sNum++;
            if (nums[i] < 0) {
                negNum++;
            }
            if (nums[i] == 0 || i == nums.length - 1) {
                if (sNum > 0) {
                    if (i == nums.length - 1) {
                        info.add(sNum);
                        info.add(i + 1);
                    } else {
                        info.add(sNum - 1);
                        info.add(i);
                    }
                    info.add(negNum);
                    sNum = 0;
                    negNum = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= info.size() - 3; i += 3) {
            int multi = 1;
            int end = info.get(i);
            if (info.get(i + 1) == 1) {
                max = max > nums[end - 1] ? max : nums[end - 1];
            } else if (info.get(i + 2) % 2 == 0) {
                for (int i1 = 0; i1 < info.get(i + 1); i1++) {
                    multi *= nums[end - i1];
                }
                if (max < multi) {
                    max = multi;
                }
            } else {
                boolean flag = false;
                for (int i1 = 0; i1 < info.get(i + 1); i1++) {
                    if (flag == true) {
                        multi *= nums[end - i1];
                    }
                    if (flag == false && nums[end - i1] < 0) {
                        flag = true;
                    }
                }
                if (max < multi) {
                    max = multi;
                }
                multi = 1;
                flag = false;
                for (Integer integer = info.get(i + 1) - 1; integer >= 0; integer--) {
                    if (flag == true) {
                        multi *= nums[end - integer];
                    }
                    if (flag == false && nums[end - integer] < 0) {
                        flag = true;
                    }
                }
                if (max < multi) {
                    max = multi;
                }
            }
        }
        return max;
    }
}
