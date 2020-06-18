package Algorithm.basicKnowledge.dataStructure.Array;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * 执行结果：
 * 通过
 */
public class FindNumIn2DArray {
    /**
     * 对越界的情况进行剪枝
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int line_len = matrix.length;
        //检查空数组
        if (line_len == 0) {
            return false;
        }
        int col_len = matrix[0].length;
        if (col_len == 0) {
            return false;
        }
        for (int i = 0; i < line_len; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            for (int j = 0; j < col_len; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    col_len = j;
                    break;
                }
            }

        }
        return false;
    }
}
