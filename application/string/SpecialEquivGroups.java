package OJSolution.application.string;

import java.util.*;

public class SpecialEquivGroups {

    /**
     * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的
     * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，
     * 一次移动包括选择两个索引 i 和 j，且 i％2 == j％2，并且交换 S[j] 和 S [i]
     * 这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
     * 返回 A 中特殊等价字符串组的数量。
     * *bwftag  一般特性 字符串匹配 动态规划 状态未知
     *
     * @param A
     * @return
     */
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            List<Character> set1 = new ArrayList<>();
            List<Character> set2 = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (j % 2 == 0) {
                    set1.add(s.charAt(j));
                } else {
                    set2.add(s.charAt(j));
                }
            }
            Collections.sort(set1);
            Collections.sort(set2);
            String se = set1.toString() + "#" + set2.toString();
            set.add(se);
        }
        return set.size();
    }
}
