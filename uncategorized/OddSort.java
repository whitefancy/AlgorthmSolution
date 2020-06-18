package OJSolution.uncategorized;

import java.util.Scanner;

public class OddSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] nums = new long[t];
        for (int i = 0; i < t; i++) {
            nums[i] = sc.nextLong();
        }
        //冒泡排序
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 1; j < n - 1; j++) {
                long a = nums[j];
                long b = nums[i];
                boolean flag = (nums[i] + nums[j]) % 2 == (long) 1;
                if (nums[j] < nums[i] && ((nums[i] + nums[j]) % 2 == 1)) {
                    long temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i--;
                    break;
                }
            }
        }

//        for (int i = n - 1; i > 0; i--) {
//            for (int j = i - 1; j >= 0; j--) {
//                long a = nums[j];
//                long b = nums[i];
//                boolean flag = (nums[i] + nums[j]) % 2 == (long) 1;
//                if (nums[j] > nums[i] && ((nums[i] + nums[j]) % 2 == 1)) {
//                    long temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    i++;
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < n - 1; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println(nums[n - 1]);
    }


}