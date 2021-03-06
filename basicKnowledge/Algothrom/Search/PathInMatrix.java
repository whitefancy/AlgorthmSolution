package Algorithm.basicKnowledge.Algothrom.Search;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 回溯法
 * 执行结果：
 * 通过
 */
public class PathInMatrix {
    int n, m;
    int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        n = board.length;
        if (n == 0) {
            return false;
        }
        m = board[0].length;
        if (word.length() > m * n) {
            return false;
        }
        char[] chars = word.toCharArray();
        boolean[][] flags = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == chars[0]) {
                    boolean temp = travel(i, j, 0, flags, board, chars);
                    if (temp == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean travel(int x, int y, int cid, boolean[][] flags, char[][] board, char[] chars) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        if (flags[x][y] == true) {
            return false;
        }
        if (board[x][y] != chars[cid]) {
            return false;
        }
        if (cid == chars.length - 1) {
            return true;
        }
        flags[x][y] = true;
        for (int k = 0; k < 4; k++) {
            boolean temp = travel(x + d[k][0], y + d[k][1], cid + 1, flags, board, chars);
            if (temp == true) {
                return true;
            }
        }
        flags[x][y] = false;
        return false;
    }
}
