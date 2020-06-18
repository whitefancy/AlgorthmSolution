package OJSolution.uncategorized;

import java.util.Scanner;
import java.util.concurrent.*;

public class MinimumTimeCost {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = MinimumTimeCost.getMinimumTimeCost(n, area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int R[][] = new int[n][n];
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(n);
        for (int i = 0; i < n; i++) {
            int a[] = {i};
            Callable<Integer> myComputation = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return getRoute(a, 0, 0);
                }

                private Integer getRoute(int[] a, int i, int count) {
                    int j = a[0];
                    if (R[j][i] != 0) {
                        return count + R[j][i];
                    }
                    if (area[i][j - 1] <= area[i][j + 1] && area[i][j - 1] <= area[i][j + 1]) {
                    }
                    return null;
                }
            };
            FutureTask<Integer> task = new FutureTask<>(myComputation);
            exec.submit(task);
        }
        return 0;
    }
}