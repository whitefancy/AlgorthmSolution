package Algorithm.basicKnowledge.dataStructure.String;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 执行结果：
 * 通过
 */
public class ReverseWordsInStringIII {
    /**
     * 双指针法
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        char[] cs = s.toCharArray();
        int lind = 0, rind = 0;
        int n = cs.length;
        while (rind < n && lind < n) {
            while (rind < n - 1 && ' ' != cs[rind + 1]) {
                rind++;
            }
            int len = rind - lind + 1;
            while (lind < rind) {
                char temp = cs[lind];
                cs[lind] = cs[rind];
                cs[rind] = temp;
                lind++;
                rind--;
            }
            lind = lind + len / 2 + len % 2 + 1;
            rind = lind;
        }
        return String.valueOf(cs);
    }
}
