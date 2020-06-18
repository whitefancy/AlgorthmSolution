package OJSolution.unsolve;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 新旧小伙伴搭配
 */
public class oldnewbuddy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        int n = sc.nextInt();
        if (n < 1) {
            return;
        }
        int[][] New = new int[n + 1][n];
        int[][] Old = new int[n + 1][n];
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int b = sc.nextInt();
                New[a][j] = b;
            }
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int b = sc.nextInt();
                Old[a][j] = b;
            }
        }
        Queue<Integer> unnew = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            unnew.offer(i);
        }
        while (!unnew.isEmpty()) {
            int i = unnew.poll();
            boolean settled = false;
            for (int j = 0; j < n; j++) {
                int want = New[i][j];
                if (ans[want] == 0) {
                    ans[want] = i;
                    settled = true;
                    break;
                } else {
                    int pri = 0, now = 0;
                    for (int k = 0; k < n; k++) {
                        if (Old[want][k] == i) {
                            now = k;
                        }
                        if (Old[want][k] == ans[want]) {
                            pri = k;
                        }
                    }
                    if (pri < now) {
                        continue;
                    } else {
                        unnew.offer(ans[want]);
                        ans[want] = i;
                        settled = true;
                        break;
                    }
                }
            }
            if (!settled) {
                unnew.offer(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + (ans[i - 1] + 1));
        }
    }
}
