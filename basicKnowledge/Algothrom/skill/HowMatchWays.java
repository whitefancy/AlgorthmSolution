package Algorithm.basicKnowledge.Algothrom.skill;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 执行结果：
 * 通过
 */
public class HowMatchWays {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = b;
            b = (a + b) % 1000000007;
            a = temp;
        }
        return b;
    }
}
