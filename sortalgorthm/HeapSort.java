package sortalgorthm;

/**
 * 堆排序
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，
 * 此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质
 * ，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
 * 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class HeapSort {
    //声明全局变量，用于记录数组array的长度；
    static int len;

    /**
     * 堆排序算法
     * 基于完全二叉树
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        HeapSort.len = array.length;
        if (HeapSort.len < 1) {
            return array;
        }
        //1.构建一个最大堆
        HeapSort.buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (HeapSort.len > 0) {
            HeapSort.swap(array, 0, HeapSort.len - 1);
            HeapSort.len--;
            HeapSort.adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (HeapSort.len / 2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            HeapSort.adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < HeapSort.len && array[i * 2] > array[maxIndex]) {
            maxIndex = i * 2;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < HeapSort.len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            HeapSort.swap(array, maxIndex, i);
            HeapSort.adjustHeap(array, maxIndex);
        }
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
