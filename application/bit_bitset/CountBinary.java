package OJSolution.application.bit_bitset;

import java.util.Scanner;

/**
 * 把一个32-bit整型转成二进制，其中包含多少个1，比如5的二进制表达是101，其中包含2个1
 * *bwftag  二进制 位运算 状态ok
 */
public class CountBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = 0;
            long n1 = sc.nextLong();
            String s = Long.toBinaryString(n1);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
