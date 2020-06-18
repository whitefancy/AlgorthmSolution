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
public class CheckDuichengNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long temp = 0;
            try {
                temp = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("false");
                sc.next();
                continue;
            }
            if (temp < 0) {
                System.out.println("false");
                continue;
            }
            if (CheckDuichengNum.isDC("" + temp)) {
                System.out.println("true");
            } else {
                System.out.println("false");
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
