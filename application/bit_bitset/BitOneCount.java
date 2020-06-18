package OJSolution.application.bit_bitset;


import java.util.BitSet;

public class BitOneCount {
    public static void main(String[] args) {
        System.out.println(new BitOneCount().hammingDistance(1343253235
                , 54345324));
        System.out.println(new BitOneCount().hammingDistance(5, 10));
        System.out.println(new BitOneCount().hammingDistance(5, 4));
        new BitOneCount().countBits(10);
    }

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * <p>
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * bwftag 位图 位运算
     *
     * @param x
     * @param y
     * @return
     */
    private int hammingDistance(int x, int y) {
        BitSet bitSet = new BitSet();
        BitSet bitSet1 = new BitSet();
        char[] chars = Integer.toBinaryString(x).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                bitSet.set(chars.length - i - 1);
            }
        }
        chars = Integer.toBinaryString(y).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                bitSet1.set(chars.length - i - 1);
            }
        }
        int distance = 0;
        for (int i = 0; i < 34; i++) {
            if (bitSet.get(i) ^ bitSet1.get(i)) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回
     * 对于所有的数字，只有两类：
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
     * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
     */
    private int[] countBits(int num) {
        int[] arr = new int[num + 1];
        if (num < 1) {
            return arr;
        }
        arr[1] = 1;
        if (num < 2) {
            return arr;
        }
        arr[2] = 1;
        for (int i = 3; i <= num; i++) {
            if (0 == (i & 1)) {
                arr[i] = arr[i >> 1];
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr;
    }
}
