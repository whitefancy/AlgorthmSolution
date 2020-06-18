package OJSolution.application.DFSBFS;

import java.util.Scanner;

public class QuanDiYunDong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n < 3) {
            System.out.println(-1);
            return;
        }
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long k = scanner.nextLong();
            if (k > max) {
                max = k;
            }
            sum += k;
            if (i >= 2) {
                if (2 * max < sum) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        System.out.println(-1);
        return;
    }
}
