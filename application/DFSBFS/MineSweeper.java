package OJSolution.application.DFSBFS;

import java.util.Arrays;

/**
 * 扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 
 * 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
 * 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 */
public class MineSweeper {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
    private int m, n;

    public static void main(String[] args) {
        char[][] A = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        char[][] AA = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};
        char[][] A1 = {{'B', 'B', 'B', 'B', 'B', 'B', '1', 'E'}, {'B', '1', '1', '1', 'B', 'B', '1', 'M'}, {'1', '2', 'M', '1', 'B', 'B', '1', '1'}, {'M', '2', '1', '1', 'B', 'B', 'B', 'B'}, {'1', '1', 'B', 'B', 'B', 'B', 'B', 'B'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}, {'B', '1', '2', '2', '1', 'B', 'B', 'B'}, {'B', '1', 'M', 'M', '1', 'B', 'B', 'B'}};
        int[] c = {0, 7};
        char[][] b = new MineSweeper().updateBoard(A1, c);
        System.out.println(Arrays.deepToString(b));
    }

    /**
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），
     * 根据以下规则，返回相应位置被点击后对应的面板：
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     *
     * @param board
     * @param click
     * @return
     */
    private char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0) {
            return null;
        }
        m = board.length;
        n = board[0].length;
        char[][] ans = new char[m][n];
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'E') {
            DFS(board, click[0], click[1], ans);// 'E'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans[i][j] == '\u0000') {
                        ans[i][j] = board[i][j];
                    }
                }
            }
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[i][j] = board[i][j];
                }
            }
            if (board[x][y] == 'M') {
                ans[x][y] = 'X';
            }
        }
        return ans;
    }

    private void DFS(char[][] board, int i, int j, char[][] ans) {
        int x, y;
        int mine = 0;
        if (ans[i][j] != '\u0000') {
            return;
        }
        for (int[] d : MineSweeper.dirs) {
            x = i + d[0];
            y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (board[x][y] == 'M' || board[x][y] == 'X') {
                    ans[x][y] = board[x][y];
                    mine++;
                }
            }
        }
        if (mine == 0) {
            ans[i][j] = 'B';
            for (int[] d : MineSweeper.dirs) {
                x = i + d[0];
                y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    DFS(board, x, y, ans);
                }
            }
        } else {
            ans[i][j] = (char) ('0' + mine);
        }
    }
}
