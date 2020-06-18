package OJSolution.uncategorized;

import java.util.Arrays;
import java.util.Scanner;

public class NumRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        for (long i = 0; i < t; i++) {
            long n = sc.nextLong();
            long[] nums = new long[(int) n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextLong();
            }
            Arrays.sort(nums);
            long a;
            long b;
            long c;
            boolean flag = false;
            for (long j = 0; j < nums.length; j++) {
                if (j == 0) {
                    a = nums[nums.length - 1];
                    b = nums[(int) j];
                    c = nums[(int) j + 1];
                } else if (j == nums.length - 1) {

                    a = nums[(int) j - 1];
                    b = nums[(int) j];
                    c = nums[0];
                } else {
                    a = nums[(int) j - 1];
                    b = nums[(int) j];
                    c = nums[(int) j + 1];
                }
                if (b > a + c) {
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("YES");
            }
        }
    }
}
