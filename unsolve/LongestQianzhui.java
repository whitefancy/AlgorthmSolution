package OJSolution.unsolve;

class LongestQianzhui {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() > max) {
                max = s.length();
            }
            if (s.length() < min) {
                min = s.length();
            }
        }
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        if (min == 0) {
            return "";
        }
        char[][] chars = new char[strs.length][max];
        for (int i = 0; i < strs.length; i++) {
            char[] sc = strs[i].toCharArray();
            chars[i] = sc;
        }
        int k = 0;
        while (k < min) {
            char p = chars[k][0];
            for (int i = 0; i < strs.length; i++) {
                if (chars[i][0] != p) {
                    break;
                }
            }
        }
        return strs[0].substring(0, k);
    }
}