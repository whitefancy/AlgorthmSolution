package OJSolution.unsolve;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Orange {
    private int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    int id = i * C + j;
                    queue.add(id);
                    map.put(id, 0);
                }
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int row = cur / C, col = cur % C;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= 0 && c >= 0 && r < R && c < C) {
                    if (grid[r][c] == 1) {
                        int id = r * C + c;
                        queue.add(id);
                        ans = map.get(cur) + 1;
                        map.put(id, ans);
                        grid[r][c] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public void test() {
        int[][] grid;
        int ans;
        grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        ans = orangesRotting(grid);
        System.out.println(ans);
        grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        ans = orangesRotting(grid);
        System.out.println(ans);
    }
}
