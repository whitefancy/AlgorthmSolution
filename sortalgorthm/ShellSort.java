package sortalgorthm;

/**
 * 希尔排序
 * 也称为缩小增量排序
 * 基本步骤，在此我们选择增量gap=length/2，
 * 对每组使用直接插入排序算法排序；
 * 缩小增量继续以gap = gap/2的方式，两两合并分组
 * 对每组使用直接插入排序算法排序
 * 直到合并成一组
 */
public class ShellSort {
    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
