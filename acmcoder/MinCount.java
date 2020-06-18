package acmcoder;

import java.util.Scanner;

/**
 * 给出一个长度为n的数组a，
 * 你需要在这个数组中找到一个长度至少为m的区间，
 * 使得这个区间内的数字的和尽可能小。
 */
public class MinCount {
    int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int m = sc.nextInt();
        int[][] nots = new int[m][2];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            A[i] = a;
        }
        System.out.println(new MinCount().minCount(A, m));
    }

    private static int countM(int[] A, int m, int i) {
        int count = 0;
        for (int j = i; j < i + m; j++) {
            count += A[j];
        }
        return count;
    }

    private int minCount(int[] A, int m) {
        dp = new int[A.length][A.length];
        int mins = Integer.MAX_VALUE;
        for (int j = m; j < A.length; j++) {
            for (int i = 0; i < A.length - j; i++) {
                dp[j - m][i] = MinCount.countM(A, j, i);
                if (dp[j - m][i] < mins) {
                    mins = dp[j - m][i];
                }
            }
        }
        return mins;
    }

}
