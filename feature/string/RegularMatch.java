package OJSolution.feature.string;

/**
 * 给你一个字符串 s 和一个字符规律 p，
 * 请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * <p>
 * *bwftag  一般特性 字符串规则 正则表达式 状态未知
 */
class RegularMatch {
    public static void main(String[] args) {
        System.out.println(new RegularMatch().isMatch("aa", "a*") == true);
        System.out.println(new RegularMatch().isMatch("aa", "a.") == true);
        System.out.println(new RegularMatch().isMatch("Caa", "C.*") == true);
        System.out.println(new RegularMatch().isMatch("aa", "a") == false);
        System.out.println(new RegularMatch().isMatch("cab", "c*a*b*") == true);
        System.out.println(new RegularMatch().isMatch("caa", "c*a*b*") == false);
        System.out.println(new RegularMatch().isMatch("abac", "a.a*") == false);
        System.out.println(new RegularMatch().isMatch("aba", "aba.") == false);
        System.out.println(new RegularMatch().isMatch("aba*", "aba*b") == false);
    }

    /**
     * @param s 可能为空，且只包含从 a-z 的小写字母。
     * @param p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * @return
     */
    private boolean isMatch(String s, String p) {
        if (s.isEmpty() || p.isEmpty()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        int i = 0, j = 0;
        int n1 = s.length(), n2 = p.length();
        boolean hasRe = false;
        while (i < n1 && j < n2) {
            if (chars1[j] == '.' || chars1[j] == '*') {
                hasRe = true;
                if (chars1[j] == '.') {
                    i++;
                    j++;
                } else {
                    if (chars[i] != chars[i - 1]) {
                        j++;
                    } else {
                        i++;
                    }
                }
            } else {
                if (chars[i] != chars1[j]) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }
        if (!hasRe) {
            return s.equals(p);
        }
        if (j < n2) {
            for (int k = j; k < n2; k++) {
                if (chars1[k] != '*') {
                    return false;
                }
            }
        }
        if (i < n1) {
            return false;
        }
        return true;
    }
}