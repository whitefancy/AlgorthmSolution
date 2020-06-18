package Algorithm.basicKnowledge.dataStructure.String;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindromicSubString {
    /**
     * 马拉车算法
     * <p>
     * #a#b#c#
     * 执行结果：
     * 通过
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        String ms = sb.toString();
        int r = 1;
        int ind = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < ms.length() - 1; i++) {
            queue.offer(i);
        }
        queue.offer(null);
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            if (temp == null) {
                if (queue.isEmpty()) {
                    break;
                }
                r++;
                queue.offer(null);
                continue;
            }
            if (temp - r > -1 && temp + r < ms.length() && ms.charAt(temp - r) == ms.charAt(temp + r)) {
                queue.offer(temp);
                ind = temp;
            }
        }
        return ms.substring(ind - r + 1, ind + r).replace("#", "");
    }
}
