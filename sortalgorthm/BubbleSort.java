package sortalgorthm;

/**
 * 冒泡排序
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
