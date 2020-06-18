package OJSolution.application.heap_priorityqueue;

import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 */
public class FindMetrixEle {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(matrix.length * matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
