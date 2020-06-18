package Algorithm.basicKnowledge.dataStructure.String.Longest;

/**
 * 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * 执行结果：
 * 通过
 */
public class CountBinarySubstring {
    /**
     * 我们可以将字符串 s 转换为 groups 数组表示字符串中相同字符连续块的长度。例如，如果 s=“11000111000000”，则 groups=[2，3，3，6]。
     * 线性扫描 答案是我们看到的每个不同的 (prev, cur) 的 min(prev, cur) 之和。
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        if (s == null) {
            return 0;
        }
        int a = 1;
        int pre = 0;
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                a++;
            } else {
                ans += Math.min(pre, a);
                pre = a;
                a = 1;
            }
        }
        ans += Math.min(pre, a);
        return ans;
    }
}
