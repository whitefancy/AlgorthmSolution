package Algorithm.basicKnowledge.Maths;

/**
 * 复数乘法
 * 给定两个表示复数的字符串。
 * <p>
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 执行结果：
 * 通过
 */
public class ComplexNumMulti {
    public String complexNumberMultiply(String a, String b) {
        int[] a1 = convert(a);
        int[] a2 = convert(b);
        int x = a1[0] * a2[0] - a1[1] * a2[1];
        int y = a1[0] * a2[1] + a1[1] * a2[0];
        return "" + x + "+" + y + "i";
    }

    int[] convert(String s) {
        String[] s1 = s.split("\\+|i");
        int[] a = new int[2];
        a[0] = Integer.parseInt(s1[0]);
        a[1] = Integer.parseInt(s1[1]);
        return a;
    }
}
