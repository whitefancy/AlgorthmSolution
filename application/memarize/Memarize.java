package OJSolution.application.memarize;

/**
 * 记忆化
 * 空间开销为缓存的大小
 */
public class Memarize {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public static void main(String[] args) {
        int[][] A = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        Memarize memarize = new Memarize();
        int a = memarize.longestIncreasingPath(A);
        System.out.println(a);
    }

    /**
     * 给定一个整数矩阵，找出最长递增路径的长度。
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。
     * 你不能在对角线方向上移动或移动到边界外（即不允许环绕）
     * 对于复杂拓扑问题（如本题），使用记忆化搜索通常是更容易更好的选择。
     *
     * @param matrix
     * @return
     */
    private int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, DFS(matrix, i, j, cache));
            }
        }
        return ans;
    }

    private int DFS(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        for (int[] d : Memarize.dirs
        ) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], DFS(matrix, x, y, cache));
            }
        }
        return ++cache[i][j];
    }
}
