package OJSolution.application.DFSBFS;

import java.util.HashSet;
import java.util.Set;

public class OrangesRot {
    private int time = 0;
    private int rotNum = 0;
    private int n = 0;
    private int m = 0;

    public int orangesRotting(int[][] grid) {
        int ans = -1;
        boolean status = true;
        n = grid.length;
        m = grid[0].length;
        Set<Orange> rots = new HashSet<>();
        Set<Orange> fresh = new HashSet<>();
        while (status || rotNum > 0) {
            rotNum = rots(grid);
            status = checkOranges(grid);
        }
        if (status = false) {
            ans = time;
        }
        return ans;

    }

    private int rots(int[][] grid) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    count += rotting(i, j, grid);
                }
            }
        }
        return 0;
    }

    private int rotting(int i, int j, int[][] grid) {
        boolean fresh = true;
        if (i > 0) {
            if (grid[i][j] == 1) {
                fresh = true;
                return 0;
            }
        }
        return 0;
    }

    private boolean checkOranges(int[][] grid) {
        boolean fresh = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh = true;
                    return fresh;
                }
            }
        }
        return fresh;
    }

    class Orange {
        int row;
        int col;

        public void Orange(int r, int c) {
            row = r;
            col = c;
        }
    }
}

