package Algorithm.basicKnowledge.dataStructure.String;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 */
public class LongestPalindromicSubsequence {
    /**
     * 定义dp[i][j]:表示s[i...j]之间的最长子序列的长度，注意是子序列，不是子串，子序列是可以跳跃的，子串不可以
     * 有两种遍历方式
     * 斜着遍历
     * 倒着遍历
     * 为啥这个问题要这样定义二维的 dp 数组呢？我们前文多次提到，找状态转移需要归纳思维，说白了就是如何从已知的结果推出未知的部分，这样定义容易归纳，容易发现状态转移关系。
     * <p>
     * 执行结果：
     * 通过
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i > -1; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
