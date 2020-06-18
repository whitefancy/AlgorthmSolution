package OJSolution.application.maths;

import java.util.Scanner;

public class CountOne {
    //    NowCoder总是力争上游，凡事都要拿第一，所以他对“1”这个数情有独钟。爱屋及乌，他也很喜欢包含1的数，例如10、11、12……。不仅如此，他同样喜欢任意进制中包含1的数。当然，其中包含1的个数越多他越喜欢。你能帮他统计一下某个数在特定的进制下1的个数吗？
    private int countOne(long n, int r) {
        long cur = n;
        int sum = 0;
        while (cur / r > 0) {
            if (cur % r == 1) {
                sum++;
            }
            cur = cur / r;
        }
        if (cur % r == 1) {
            sum++;
        }
        return sum;
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            int r = sc.nextInt();
            System.out.println(countOne(n, r));
        }
    }
}
