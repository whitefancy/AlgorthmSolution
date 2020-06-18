package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

/**
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * <p>
 * 提示：
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 * 执行结果：
 * 通过
 */
public class AddWithoutPlus {
    /**
     * 解题思路
     * ps:异或也叫半加运算，其运算法则相当于不带进位的二进制加法：所以异或常被认作不进位加法。
     * 不能用加法，所以只能用二进制进位来算。把相加和进位分开，分成两步。
     * step1:a^b，完成不进位加法。step2:a&b，完成进位的运算。step3:把step2左移一位，模拟正常加法的向前进一位。一直到进行到进位没有为止，也就是step3=0的时候，说明全部进位完成，加法u全部算完了。
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            int t1 = a ^ b;
            int t2 = (a & b) << 1;
            a = t1;
            b = t2;
        }
        return a;
    }
}
