package OJSolution.application.bit_bitset;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * 将40亿个不同数据进行排序
 * 不知道该如何存放，因为BitSet是int的
 * bwftag 位图 大数据
 */
public class NumbersSort {
    public static void main(String[] args) {
        Random random = new Random();
        List<Long> list = new ArrayList<>(2000000000);
        List<Long> list1 = new ArrayList<>(2000000000);
        for (int i = 0; i < 2000000000; i++) {
            long rand = random.nextLong();
        }
        int k = Integer.MAX_VALUE;
        long k1 = Long.MAX_VALUE;
        BitSet bitSet = new BitSet(2000000000);
        bitSet.set(Integer.MAX_VALUE);
        bitSet.flip(1);
    }
}
