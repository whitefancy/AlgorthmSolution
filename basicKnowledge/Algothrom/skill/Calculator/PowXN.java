package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class PowXN {
    /**
     * 提交记录
     * 通过
     * 我们从 xx 开始不断地进行平方，得到 x^2, x^4, x^8, x^{16}, \cdotsx
     * 2
     * ,x
     * 4
     * ,x
     * 8
     * ,x
     * 16
     * ,⋯，如果 nn 的第 kk 个（从右往左，从 00 开始计数）二进制位为 11，那么我们就将对应的贡献 x^{2^k}x
     * 2
     * k
     * <p>
     * 计入答案。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long m = n;
        return n > 0 ? fn(x, m) : 1.0 / fn(x, -m);
    }

    double fn(double x, long n) {
        double ans = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x;// 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                if (ans == 0) {
                    return ans;
                }
            }
            // 将贡献不断地平方
            x = x * x;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n = n / 2;
        }
        return ans;
    }
}
