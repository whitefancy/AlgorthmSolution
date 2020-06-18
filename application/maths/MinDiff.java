package OJSolution.application.maths;

import java.util.Scanner;

/**
 * 给定一个正整数n，计算n与斐波那契数的最小差值(绝对值)
 */
public class MinDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int target = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int a = 0;
            int b = 1;
            int c = 0;
            if (target <= 0) {
                System.out.println(-target);
                continue;
            }
            while (true) {
                c = a + b;
                int diff = Math.abs(target - c);
                if (diff < min) {
                    min = diff;
                } else {
                    System.out.println(min);
                    break;
                }
                a = b;
                b = c;
            }

        }
    }
}
