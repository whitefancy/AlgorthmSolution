package Algorithm.basicKnowledge.Algothrom.Search;

/**
 * 排序矩阵查找
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class SortedMatrixSearch {
    /**
     * 通过
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        return searchMatrix(matrix, target, 0, n - 1, 0, m - 1);
    }

    boolean searchMatrix(int[][] mat, int t, int l, int r, int u, int d) {
        if (t < mat[u][l]) {
            return false;
        }
        if (t > mat[d][r]) {
            return false;
        }
        while (r > -1 && t < mat[u][r]) {
            r--;
        }
        while (d > -1 && t < mat[d][l]) {
            d--;
        }
        while (u <= d && t > mat[u][r]) {
            u++;
        }
        while (l <= r && t > mat[d][l]) {
            l++;
        }
        if (u > d || l > r || r == -1 || d == -1) {
            return false;
        }
        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (mat[i][j] == t) {
                    return true;
                }
            }
        }
        return false;
    }
}
