package OJSolution.application.bit_bitset;

import java.util.LinkedList;
import java.util.List;

/**
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）
 * 每个子串的长度为10
 * <p>
 * bwftag 位图 动态规划 未完成
 */
public class DnaSequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        /*
        A 00，C 01，G 10, T 11
         */
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

        }
        return ans;
    }
}
