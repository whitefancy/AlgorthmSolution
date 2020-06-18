package OJSolution.application.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * *bwftag   字符串变换 状态AC
 */
class ZlineConvert {

    public static void main(String[] args) {
        System.out.println(new ZlineConvert().convert1("LEETCODEISHIRING", 3));
    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * https://leetcode-cn.com/problems/zigzag-conversion/
     * *bwftag   字符串变换 状态AC
     */
    private String convert(String s, int numRows) {
        if (numRows < 2 || s.length() <= numRows) {
            return s;
        }
        List<List<Character>> lists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Character> list = new LinkedList<>();
            lists.add(list);
        }
        char[] chars = s.toCharArray();
        int i = 0, d = 0;
        for (int k = 0; k < chars.length; k++) {
            char c = chars[k];
            lists.get(i).add(c);
            if (i == numRows - 1) {
                d = -1;
            } else if (i == 0) {
                d = 1;
            }
            i = i + d;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : lists) {
            for (Character c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * https://leetcode-cn.com/problems/zigzag-conversion/
     * *bwftag   字符串变换 状态AC
     */
    private String convert1(String s, int numRows) {
        if (numRows < 2 || s.length() <= numRows) {
            return s;
        }
        int[] line = new int[s.length()];
        char[] chars = s.toCharArray();
        int i = 0, d = 0;
        for (int k = 0; k < chars.length; k++) {
            line[k] = i;
            if (i == numRows - 1) {
                d = -1;
            } else if (i == 0) {
                d = 1;
            }
            i = i + d;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            for (int j = 0; j < chars.length; j++) {
                if (line[j] == k) {
                    sb.append(chars[j]);
                }
            }
        }
        return sb.toString();
    }
}