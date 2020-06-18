package OJSolution.application.bit_bitset;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * 有1千万个随机数，随机数的范围在1到1亿之间。
 * 现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
 */
public class FindNumbers {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        FindNumbers findNumbers = new FindNumbers();
        int[] A = {3, 4, 3, 4, 2, 5};
        findNumbers.singleNumber(A);
    }

    /**
     * 有1千万个随机数，随机数的范围在1到1亿之间。
     * 现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
     * *bwftag 位图 大数据
     *
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    private static void testMethod() throws FileNotFoundException, UnsupportedEncodingException {
        Random random = new Random();
        PrintWriter out = new PrintWriter("../../../test/test1", "UTF-8");
        List<Integer> list = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; i++) {
            list.add(random.nextInt(100000000));
        }
        BitSet bitSet = new BitSet(100000000);
        for (int i = 0; i < 10000000; i++) {
            bitSet.set(list.get(i));
        }
        for (int i = 0; i < 100000000; i++) {
            if (!bitSet.get(i)) {
                out.print(i + " ");
            }
            if (i % 100 == 99) {
                out.println();
            }
        }
        out.close();
    }

    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
     */
    private int[] singleNumber(int[] nums) {
        BitSet bitSet = new BitSet();
        bitSet.flip(Integer.MAX_VALUE - Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            bitSet.flip(nums[i] - Integer.MIN_VALUE);
        }
        int[] ans = new int[2];
        ans[0] = bitSet.nextSetBit(0) + Integer.MIN_VALUE;
        ans[1] = bitSet.nextSetBit(ans[0] + 1) + Integer.MIN_VALUE;
        return ans;
    }
}
