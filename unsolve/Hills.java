package OJSolution.unsolve;

import java.util.*;

/**
 * 数列中，如果成山峰形状递增递减，称为山峰数。
 * 求给定长度n，两个连续数字之间差值小于k，通过在给定m个数据中选取，能生成多少个长度为n的山峰数列。
 */
public class Hills {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] list1 = new int[n];
            for (int i = 0; i < n; i++) {
                list1[i] = (sc.nextInt());
            }
            int k = sc.nextInt();
            Arrays.sort(list1);
            long ln = 0;
            for (int ind = n - 3; ind >= 0; ind--) {
                ln = Hills.countHills(n, k, list1, ln, ind);
            }
            System.out.println(ln);
        }
    }

    private static long countHills(int n, int k, int[] list, long ln, int ind) {
        if (ln == 0) {
            if (list[ind + 2] - list[ind] <= k) {
                ln = 2;
            }
            return ln;
        }
        int ic = 0;
        for (int i = ind + 1; i < n; i++) {
            if (list[i] - list[ind] <= k) {
                ic += 1;
            }
        }
        return ln * ic % 1234567891;
    }
}
