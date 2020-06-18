package OJSolution.unsolve;

import java.util.Scanner;

/**
 * 求最长完美子序列
 * 第n个数>=前n-1个数之和
 */
public class LongestPerfectSubList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                A[j] = a;
            }
            System.out.println(new LongestPerfectSubList().findLongest(n, A));
        }
    }

    /**
     * * 有正有负的数组
     * * 求其和最大的连续子串
     *
     * @param n
     * @param A
     * @return
     */
    private int findLongest(int n, int[] A) {
        int max = 1;
        long sum = A[0];
        int cur = 0;
        for (int i = 1; i < A.length; i++) {
            sum = 0;
            for (int j = cur; j < i; j++) {
                sum += A[j];
            }
            if (A[i] >= sum && max < (i - cur)) {
                max = i - cur;
            } else if (A[i] < sum) {
                cur++;
                break;
            }
        }
        return max;
    }
}
