package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 若 n = 2^xn=2
 * x
 * 且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
 * 恒有 n & (n - 1) == 0，这是因为：
 * nn 二进制最高位为 11，其余所有位为 00；
 * n - 1n−1 二进制最高位为 00，其余所有位为 11；
 * 一定满足 n > 0。
 * 因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足
 * 执行结果：
 * 通过
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
