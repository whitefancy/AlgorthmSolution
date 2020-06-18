package OJSolution.application.maths;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 给定一个正数，找到离它最近的对称数
 * 例如 11 11
 * 10 9 和 11
 * 1345 1331
 * 已解决
 */
public class FindDuichengNum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long temp = 0;
            try {
                temp = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("ERROR");
                sc.next();
                continue;
            }
            if (temp < 0) {
                System.out.println("ERROR");
                continue;
            }
            long a = temp;
            long a1 = 0, a2 = 0;
            while (a > 0) {
                if (FindDuichengNum1.isDC("" + a)) {
                    a1 = a;
                    break;
                }
                a--;
            }
            a = temp + 1;
            while (a < Long.MAX_VALUE) {
                if (FindDuichengNum1.isDC("" + a)) {
                    a2 = a;
                    break;
                }
                a++;
            }
            if (Math.abs(temp - a1) == Math.abs(a2 - temp)) {
                System.out.println(a1 + "," + a2);
            } else if (Math.abs(temp - a1) < Math.abs(a2 - temp)) {
                System.out.println(a1);
            } else {
                System.out.println(a2);
            }
        }
    }

    private static boolean isDC(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
