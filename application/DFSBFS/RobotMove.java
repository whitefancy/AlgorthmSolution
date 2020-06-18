package OJSolution.application.DFSBFS;

import java.util.Scanner;

/**
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 请问该机器人能够达到多少个格子？
 * 一行三个正整数由空格分开，分别代表行数m，列数n，和坐标数位之和的阈值k，0 < m <= 100, 0 < n <= 100, 0 < k <= 20。
 */
public class RobotMove {
    private long count = 0;
    private int threshold;
    private boolean[][] isChecked;
    private int[][] value;
    private int n;
    private int m;

    private RobotMove(int m, int n, int k) {
        this.m = m;
        this.n = n;
        isChecked = new boolean[m][n];
        value = new int[m][n];
        threshold = k;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value[i][j] = caculateValue(i, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m, n, k;
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            if (m == 0 || n == 0) {
                System.out.println(0);
                continue;
            }
            if (k == 0) {
                System.out.println(1);
                continue;
            }

            RobotMove so = new RobotMove(m, n, k);
            so.move(0, 0);
            System.out.println(so.getCount());
        }
    }

    long getCount() {
        return count;
    }

    private int caculateValue(int x, int y) {
        char[] x1 = (String.valueOf(x) + y).toCharArray();
        int val = 0;
        for (int i = 0; i < x1.length; i++) {
            val += x1[i] - '0';
        }
        return val;
    }

    private void move(int x, int y) {
        if (x < 0 || y < 0 || x == m || y == n) {
            return;
        }
        if (isChecked[x][y]) {
            return;
        }
        isChecked[x][y] = true;
        if (value[x][y] <= threshold) {
            count++;
        }
        move(x + 1, y);
        move(x, y + 1);
        move(x - 1, y);
        move(x, y - 1);
    }
}
