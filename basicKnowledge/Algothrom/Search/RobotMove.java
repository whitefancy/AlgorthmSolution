package Algorithm.basicKnowledge.Algothrom.Search;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 执行结果：
 * 通过
 */
public class RobotMove {
    int ans = 0;
    int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] flags;

    public int movingCount(int m, int n, int k) {
        flags = new int[m][n];
        travel(0, 0, m, n, k);
        return ans;
    }

    /**
     * 回溯法，只需要标记为1的，就不要再check了
     *
     * @param x
     * @param y
     * @param m
     * @param n
     * @param count
     */
    void travel(int x, int y, int m, int n, int count) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        if (flags[x][y] != 0) {
            return;
        }
        if (sum(x) + sum(y) > count) {
            flags[x][y] = 2;
            return;
        }
        flags[x][y] = 1;
        ans++;
        for (int k = 0; k < 4; k++) {
            travel(x + d[k][0], y + d[k][1], m, n, count);
        }
    }

    int sum(int a) {
        char[] a1 = String.valueOf(a).toCharArray();
        int b = 0;
        for (int i = 0; i < a1.length; i++) {
            b += a1[i] - '0';
        }
        return b;
    }
}
