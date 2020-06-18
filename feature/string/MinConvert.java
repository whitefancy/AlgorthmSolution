package OJSolution.feature.string;

import java.util.Scanner;

/**
 * 字符串最小变换次数——动态规划
 * 从字符串变道另一个字符串的最小变换次数 替换，删除，增加
 * *bwftag  一般特性 字符串转换 状态ok
 */
public class MinConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int n1 = s1.length();
            int n2 = s2.length();
            int[][] dp = new int[n1 + 1][n2 + 1];
            if (n1 == 0 || n2 == 0) {
                System.out.println(Math.max(n1, n2));
                return;
            }
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            for (int i = 0; i <= n1; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= n2; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    int before = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    if (chars1[i - 1] != chars2[j - 1]) {
                        dp[i][j] = before + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            int k = dp[n1][n2];
            System.out.println(k);
        }
    }
}
