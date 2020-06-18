package OJSolution.application.DFSBFS;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FriendCycles {
    private boolean[] isVisited;
    private int m, n;

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        A = new int[][]{{1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        FriendCycles friendCycles = new FriendCycles();
        System.out.println(friendCycles.findCircleNum(A));
    }

    /**
     * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/friend-circles
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param M
     * @return
     */
    private int findCircleNum(int[][] M) {
        int num = 0;
        if (M.length == 0) {
            return 0;
        }
        m = M.length;
        n = M[0].length;
        isVisited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (isVisited[i] == false) {
                num++;
                travel(M, isVisited, i);
            }
        }
        return num;
    }

    private void travel(int[][] M, boolean[] isVisited, int i) {
        isVisited[i] = true;
        for (int j = 0; j < m; j++) {
            if (M[i][j] == 1 && isVisited[j] == false) {
                travel(M, isVisited, j);
            }
        }
    }
}
