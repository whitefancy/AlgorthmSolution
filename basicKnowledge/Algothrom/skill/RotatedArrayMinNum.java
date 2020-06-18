package Algorithm.basicKnowledge.Algothrom.skill;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 执行结果：
 * 通过
 */
public class RotatedArrayMinNum {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        return minArray(0, numbers.length - 1, numbers);
    }

    /**
     * 二分查找
     *
     * @param a
     * @param b
     * @param numbers
     * @return
     */
    int minArray(int a, int b, int[] numbers) {
        if (a + 1 == b) {
            return numbers[a] > numbers[b] ? numbers[b] : numbers[a];
        }
        if (numbers[a] < numbers[b]) {
            return numbers[a];
        } else {
            int l = minArray(a, b - (b - a) / 2, numbers);
            int r = minArray(a + (b - a) / 2, b, numbers);
            return l < r ? l : r;
        }
    }
}
