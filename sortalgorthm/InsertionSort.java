package sortalgorthm;

/**
 * 插入排序
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 */
public class InsertionSort {
    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
