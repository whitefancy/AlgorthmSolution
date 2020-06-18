package OJSolution.feature.string;

import java.util.Scanner;

/**
 * 给定一个字符串，请找出其中长度最长且不含有重复字符的子串，计算该子串长度。
 * *bwftag  一般特性 连续子串 动态规划 状态ok
 */
public class LongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            int l = 0;//上次重复的后一位
            int max = 1;//当前记录的最大子串的长度
            int len;//当前最后一个子串的长度
            for (int i = 1; i < chars.length; i++) {
                int j = LongestSubstring.indexof(chars, l, i, chars[i]);//当前字符重复的位置
                if (j != -1) {
                    len = Math.max(j - l + 1, i - j);
                    if (len > max) {
                        max = len;
                    }
                    l = j + 1;
                } else if (i == chars.length - 1) {
                    len = chars.length - l;
                    if (len > max) {
                        max = len;
                    }
                }
            }
            System.out.println(max);
        }
    }

    private static int indexof(char[] chars, int from, int to, char c) {
        for (int i = from; i < to; i++) {
            if (c == chars[i]) {
                return i;
            }
        }
        return -1;
    }
}
