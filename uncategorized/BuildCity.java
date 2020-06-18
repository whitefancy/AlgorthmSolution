package OJSolution.uncategorized;

import java.util.Scanner;

public class BuildCity {
    public static void main(String[] args) {
        long[] h = {0, 0};
        long[] w = {0, 0};
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        h[0] = scanner.nextLong();
        w[0] = scanner.nextLong();
        h[1] = h[0];
        w[1] = w[0];
        for (int i = 1; i < n; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            if (x < h[0]) {
                h[0] = x;
            } else if (x > h[1]) {
                h[1] = x;
            }
            if (y < w[0]) {
                w[0] = y;
            } else if (y > w[1]) {
                w[1] = y;
            }
        }
        long length = (w[1] - w[0]) > (h[1] - h[0]) ? (w[1] - w[0]) : (h[1] - h[0]);
        System.out.println(length * length);
    }
}
