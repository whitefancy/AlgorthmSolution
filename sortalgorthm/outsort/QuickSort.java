package sortalgorthm.outsort;

//快速排序
public class QuickSort {
    public int data[];

    public static void sort(int data[], int low, int hight) {
        QuickSort qs = new QuickSort();
        qs.data = data;
        qs.sort(low, hight);
    }

    /**
     * 在序列中任意选择一个数，然后把序列分成比这个数大的和比这个数小的两个子序列。不断重复以上步骤完成排序。
     * 优化： 三数取中。最好的情况下是每次都能取数组的中位数作为切分元素，但是计算中位数的代价很高。人们发现取 3 个元素并将大小居中的元素作为切分元素的效果最好。
     *
     * @param sortArray
     * @param low
     * @param hight
     * @return
     */
    private int partition(int sortArray[], int low, int hight) {
        int key = sortArray[low];
        while (low < hight) {
            while (low < hight && sortArray[hight] >= key) {
                hight--;
            }
            sortArray[low] = sortArray[hight];
            while (low < hight && sortArray[low] <= key) {
                low++;
            }
            sortArray[hight] = sortArray[low];
        }
        sortArray[low] = key;
        return low;
    }

    public void sort(int low, int hight) {
        if (low < hight) {
            int result = partition(data, low, hight);
            sort(low, result - 1);
            sort(result + 1, hight);
        }
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            System.out.print(" ");
        }
    }
}