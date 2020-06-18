package OJSolution.feature.string;

class HuiwenSubString {

    public static void main(String[] args) {
        System.out.println(new HuiwenSubString().longestPalindrome("babad"));
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * *bwftag  一般特性 连续子串 滑动窗口 状态ok
     *
     * @param s
     * @return
     */
    private String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String ans = null;
        int e = 0;
        int b = 0;
        int max = 0;
        if (s.length() < 2) {
            return s;
        }
        while (b < chars.length) {
            e = b;
            while (e < chars.length) {
                boolean flag = isPali(chars, b, e);
                if (flag) {
                    if (e - b + 1 > max) {
                        max = e - b + 1;
                        ans = s.substring(b, e + 1);
                    }
                }
                e++;
            }
            b++;
        }
        return ans;
    }

    private boolean isPali(char[] chars, int b, int e) {
        while (b < e) {
            if (chars[b] != chars[e]) {
                return false;
            }
            b++;
            e--;
        }
        return true;
    }
}