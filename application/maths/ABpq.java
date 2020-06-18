package OJSolution.application.maths;

import java.util.Scanner;

/**
 * 给定加数p 和系数q 满足最小运算次数的A+p>B,其中p=p*q
 * *bwftag 数学计算 状态90% Case
 */
public class ABpq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            System.out.println(new ABpq().operationTimes(a, b, p, q));
        }
    }

    private int operationTimes(int A, int B, int p, int q) {
        if (A >= B) {
            return 0;
        }
        int count = 0;
        while (A < B) {
            if (A + p >= B) {
                return count + 1;
            }
            p = p * q;
            count++;
        }
        return 0;
    }
}
