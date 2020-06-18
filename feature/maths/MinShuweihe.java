package OJSolution.feature.maths;

import java.util.Scanner;

/**
 * 数位和为n，找出十进制下的最小数 已解决
 * *bwftag  数学特性 十进制  最小数字 状态ok
 */
public class MinShuweihe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            System.out.println(new MinShuweihe().minNumber(n));
        }
    }

    private String minNumber(int n) {
        StringBuilder ans = new StringBuilder();
        if (n < 10) {
            return "" + n;
        }
        int k = n / 9;
        for (int i = 0; i < k; i++) {
            ans.append(9);
        }
        if (n % 9 > 0) {
            ans.insert(0, n % 9);
        }
        return ans.toString();
    }
}
