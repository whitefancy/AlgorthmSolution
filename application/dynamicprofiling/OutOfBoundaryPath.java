package OJSolution.application.dynamicprofiling;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个 m × n 的网格和一个球。
 * 球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，
 * 或者往上、下、左、右四个方向上移动使球穿过网格边界。
 * 但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。
 * 答案可能非常大，返回 结果 mod 109 + 7 的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OutOfBoundaryPath {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        OutOfBoundaryPath path = new OutOfBoundaryPath();
        System.out.println(path.findPaths(2, 2, 2, 0, 0));
        System.out.println(path.findPaths(1, 3, 3, 0, 1));
        System.out.println(path.findPaths(8, 50, 23, 5, 26));
    }

    private int findPaths(int m, int n, int N, int i, int j) {
        long[][] G = new long[m + 2][n + 2];
        int[] pos = {i + 1, j + 1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(pos);
        G[i + 1][j + 1] = 1;
        for (int k = 0; k < N; k++) {
            int ki = queue.size();
            for (int l = 0; l < ki; l++) {
                pos = queue.poll();
                long point = G[pos[0]][pos[1]];
                G[pos[0]][pos[1]] = 0;
                moveOneStep(pos, G, queue, point);
            }
        }
        long count = 0;
        for (int k = 1; k <= m; k++) {
            count += G[k][0];
            count = count % (1000000007);
            count += G[k][n + 1];
            count = count % (1000000007);
        }
        for (int k = 1; k <= n; k++) {
            count += G[0][k];
            count = count % (1000000007);
            count += G[m + 1][k];
            count = count % (1000000007);
        }
        return (int) count % (1000000007);
    }

    private void moveOneStep(int[] p, long[][] G, Queue<int[]> queue, long point) {
        int x, y;
        int m, n;
        m = G.length - 2;
        n = G[0].length - 2;
        for (int[] d : dirs) {
            x = p[0] + d[0];
            y = p[1] + d[1];
            if (x > 0 && x <= m && y > 0 && y <= n && G[x][y] == 0) {
                int[] pos = {x, y};
                queue.offer(pos);
            }
            G[x][y] += 1 * point;
            G[x][y] = G[x][y] % (1000000007);
        }
    }
}
