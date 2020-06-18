package Algorithm.basicKnowledge.Algothrom.dynamic;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 */
public class CuttingRope {
    int[] cucalute;

    /**
     * 动态规划
     * <p>
     * 执行结果：
     * 通过
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        cucalute = new int[n + 1];
        if (n < 3) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        cucalute[1] = 1;
        cucalute[2] = 2;
        cucalute[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = i;
            for (int j = 3; j <= (i + 1) / 2; j++) {
                if (cucalute[j] * cucalute[i - j] > max) {
                    max = cucalute[j] * cucalute[i - j];
                }
            }
            cucalute[i] = max;
        }
        return cucalute[n];
    }

    /**
     * 算数集合不等式
     * w为e=2.7时，相等，因此值落在2和3之间
     * 执行结果：
     * 通过
     *
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if (n < 3) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long ans = 1;
        while (n > 0) {
            if (n > 4) {
                ans = ans * 3 % 1000000007;
                n = n - 3;
            } else {
                ans = ans * n % 1000000007;
                break;
            }
        }
        return (int) ans;
    }
}
