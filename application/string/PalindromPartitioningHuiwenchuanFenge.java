package OJSolution.application.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class PalindromPartitioningHuiwenchuanFenge {
    public static void main(String[] args) {
        List<List<String>> list = new PalindromPartitioningHuiwenchuanFenge().partition("efe");
        for (List<String> list1 : list) {
            for (String s : list1) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * <p>
     * 返回 s 所有可能的分割方案。
     * bwftag  回文字符串 回溯 字符串分割 状态ok
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> list = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        if (s.length() < 2) {
            ans.add(s);
            list.add(ans);
            return list;
        }
        int[] parti = new int[s.length()];
        char[] chars = s.toCharArray();
        backTracking(list, parti, 0, 0, chars);
        return list;
    }

    private void backTracking(List<List<String>> list,
                              int[] parti, int pind, int sind, char[] chars) {
        if (sind >= chars.length) {
            List<String> ans = new ArrayList<>();
            String s = String.valueOf(chars);
            int begin = 0;
            for (int i = 0; i < pind; i++) {
                int end = parti[i] + 1;
                ans.add(s.substring(begin, end));
                begin = end;
            }
            list.add(ans);
            return;
        }
        for (int i = sind; i < chars.length; i++) {
            if (!isPalindrom(chars, sind, i)) {
                continue;
            }
            parti[pind] = i;
            backTracking(list, parti, pind + 1, i + 1, chars);
        }
    }

    private boolean isPalindrom(char[] chars, int start, int end) {
        boolean flag = true;
        while (start < end) {
            if (chars[start] != chars[end]) {
                flag = false;
            }
            start++;
            end--;
        }
        return flag;
    }
}