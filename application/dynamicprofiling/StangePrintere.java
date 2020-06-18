package OJSolution.application.dynamicprofiling;

/**
 * 有台奇怪的打印机有以下两个特殊要求：
 * <p>
 * 打印机每次只能打印同一个字符序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 */
public class StangePrintere {
    /**
     * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
     *
     * @param s
     * @return
     */
    public int strangePrinter(String s) {
        char[] chars = s.toCharArray();
        int k = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[0] || chars[i] == chars[i - 1]) {

            } else {
                k++;
            }
        }
        return k;
    }
}
