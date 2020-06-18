package OJSolution.uncategorized;

import java.util.Scanner;

public class Lofter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            int count = Lofter.lofter(a, b);
            if (count == -1) {
                System.out.println("illegal input");
            } else {
                System.out.println(count);
            }
        }
    }

    private static int lofter(int a, int b) {
        int count = 0;
        if (b < a) {
            int t = b;
            b = a;
            a = t;
        }
        int k = (b - a) / 10;
        if (Lofter.isIllegal(a) || Lofter.isIllegal(b)) {
            return -1;
        }
        if (b == a) {
            return 0;
        }
        int key = (a / 10) * 10;
        if (k == 0) {
            if (a < 0) {
                key -= 4;
            } else {
                key += 4;
            }
        }
        if (k == 0 && a < key && b > key) {
            count = b - a - 1;
        } else if (k == 0 && (a > key || b < key)) {
            count = b - a;
        } else if (a > 4 || b < -4) {
            count = b - a - k * 1;
        } else if (a < -4 && b > 4) {
            count = b - a - k - 2;
        } else {
            count = b - a - k - 1;
        }
        return count;
    }

    private static boolean isIllegal(int a) {
        int k = a % 10;
        if (k == 4) {
            return true;
        }
        if (a == 0) {
            return true;
        }
        return false;
    }
}
