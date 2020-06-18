package Algorithm.basicKnowledge.dataStructure.String;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 执行结果：
 * 通过
 */
public class PalindromicSubStrings {
    /**
     * 分成奇数个和偶数个分开计算
     * 灵感 马拉车算法
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (null == s) {
            return 0;
        }
        String ms = s;
        int r = 1;
        int count = ms.length();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < ms.length() - 1; i++) {
            queue.offer(i);
        }
        queue.offer(null);
        while (true) {
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
                count++;
                queue.offer(temp);
            }
        }

        r = 1;
        for (int i = 1; i < ms.length(); i++) {
            queue.offer(i);
        }
        queue.offer(null);
        while (true) {
            Integer temp = queue.poll();
            if (temp == null) {
                if (queue.isEmpty()) {
                    break;
                }
                r++;
                queue.offer(null);
                continue;
            }
            if (temp - r > -1 && temp + r - 1 < ms.length() && ms.charAt(temp - r) == ms.charAt(temp + r - 1)) {
                count++;
                queue.offer(temp);
            }
        }
        return count;
    }
}
