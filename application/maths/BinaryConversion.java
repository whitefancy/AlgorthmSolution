package OJSolution.application.maths;

import java.util.Scanner;

public class BinaryConversion {
    private String conversion(long n, int r) {
        String s = "";
        long cur = n;
        while (cur / r > 0) {
            s = rNum(cur % r) + s;
            cur = cur / r;
        }
        if (cur % r > 0) {
            s = rNum(cur % r) + s;
        }
        return s;
    }

    private String rNum(long l) {
        if (l < 10) {
            return "" + l;
        }
        return "" + (char) ('A' + l - 10);
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            int r = sc.nextInt();
            System.out.println(conversion(n, r));
        }
    }
}
