package OJSolution.application.string;

class MyStringToInteger {
    public static void main(String[] args) {
        System.out.println(new MyStringToInteger().myAtoi("+"));

        System.out.println(new MyStringToInteger().myAtoi("  0000000000012345678"));
    }

    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，
     * 直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，
     * 则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，
     * 它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串
     * 仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * 说明：假设我们的环境只能存储 32 位大小的有符号整数，
     * 那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，
     * 请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * *bwftag  字符串解析 正负正数 状态ok
     *
     * @param str
     * @return
     */
    private int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int ind = 0, e = 0;
        while (ind < str.length()) {
            char b = chars[ind];
            if (b != ' ') {
                break;
            }
            ind++;
        }
        if (ind == str.length()) {
            return 0;
        }
        int xishu = 1;
        if ((chars[ind] == '+' || chars[ind] == '-')) {
            xishu = chars[ind] == '+' ? 1 : -1;
            ind++;
        }
        while (ind < chars.length && chars[ind] == '0') {
            ind++;
        }
        int start = ind;
        while (ind < str.length()) {
            char b = chars[ind];
            if ((b >= '0' && b <= '9')) {
                ind++;
            } else {
                break;
            }
        }
        int end = ind;
        if (start >= end) {
            return 0;
        } else if (end - start > 10) {
            if (xishu == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        long l = Long.parseLong(str.substring(start, end)) * xishu;
        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) l;
        }
    }
}