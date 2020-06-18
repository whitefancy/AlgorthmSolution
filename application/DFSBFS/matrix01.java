package OJSolution.application.DFSBFS;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1
 */
public class matrix01 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public static void main(String[] args) {
        int[][] A = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] A1 = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] B = new matrix01().updateMatrix(A1);
        B = B;
    }

    private int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ans[o1[0]][o1[1]] - ans[o2[0]][o2[1]];
            }
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    ans[i][j] = Integer.MAX_VALUE;
                } else {
                    ans[i][j] = 0;
                    boolean has1 = false;
                    for (int[] d : matrix01.dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            if (matrix[x][y] == 1) {
                                has1 = true;
                                break;
                            }
                        }
                    }
                    if (has1) {
                        int[] pos = {i, j};
                        queue.offer(pos);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            BFS(pos[0], pos[1], ans, queue);
        }
        return ans;
    }

    private void BFS(int i, int j, int[][] ans, Queue<int[]> queue) {
        for (int[] d : matrix01.dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (ans[x][y] == Integer.MAX_VALUE) {
                    ans[x][y] = ans[i][j] + 1;
                    int[] pos = {x, y};
                    queue.offer(pos);
                }
            }
        }
    }
}
