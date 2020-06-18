package OJSolution.application.maths;

import JavaBasics.TypeChange;

public class FindPaths {
    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    //
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    //
    //问总共有多少条不同的路径？
    public int uniquePaths(int a, int b) {
        long temp = 1;
        int n = a + b - 2;
        int m = a > b ? a : b;
        m -= 1;
        for (int i = m + 1; i <= n; i++) {
            temp *= i;
        }
        for (int i = 2; i <= n - m; i++) {
            temp /= i;
        }
        return (int) temp;
    }

    //给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    //说明：每次只能向下或者向右移动一步。
    private int minPathSum(int[][] grid) {
        int row, col;
        row = grid.length;
        if (row > 0) {
            col = grid[0].length;
        } else {
            return 0;
        }
        // 边界赋初始值
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += grid[i][0];
            grid[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < col; i++) {
            sum += grid[0][i];
            grid[0][i] = sum;
        }
        for (int i = 1; i < row; i++) {
            for (int i1 = 1; i1 < col; i1++) {
                grid[i][i1] = Math.min(grid[i - 1][i1], grid[i][i1 - 1]) + grid[i][i1];
            }
        }
        return grid[row - 1][col - 1];
    }

    public void test() {
        TypeChange.String2Array("[[1,3,1],[1,5,1],[4,2,1]]");
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
//        System.out.println(uniquePaths(23, 13));
    }
}
