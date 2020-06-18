package sortalgorthm;

import java.util.ArrayList;

/**
 * 基数排序
 * 基数排序是按照低位先排序，然后收集；
 * 再按照高位排序，然后再收集；
 * 依次类推，直到最高位。
 * 有时候有些属性是有优先级顺序的，
 * 先按低优先级排序，再按高优先级排序。
 * 最后的次序就是高优先级高的在前，
 * 高优先级相同的低优先级高的在前。
 * 基数排序基于分别排序，分别收集，所以是稳定的。
 */
public class RadixSort {
    /**
     * 基数排序
     *
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
