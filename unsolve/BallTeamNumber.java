package OJSolution.unsolve;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

/**
 * 小Q是篮球训练队的教练，篮球队新加入了N名队员，第i名队员的篮球水平值为ai。
 * 小Q现在要把他们按照以下的要求分为A队和B队进行训练:
 * 1、A队的队员水平值之和严格大于B队的队员水平值之和
 * 2、对于A队中的任意一名队员，如果把他分配到B队，A队的水平值之和就会严格小于B队的水平值之和。
 * 3、每个队员必须要加入一个队伍
 * 小Q现在想知道有多少种方案可以按照以上要求完成分队。
 */
public class BallTeamNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            return;
        }
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(new BallTeamNumber().TeamPlanCount(n, A));
    }

    /**
     * @param n 一个正整数n(2 <= N <= 50), 表示队员的数量。
     * @param A 包括N个正整数 ai(1 <= ai <= 6 x 104), 表示每名队员的篮球水平值, 以空格分割。
     * @return 输出一个正整数, 表示方案数。
     */
    private int TeamPlanCount(int n, int[] A) {
        Arrays.sort(A);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        int max = A[n - 1];
        int mediumIndex = 0;//A中最多的人数。
        int minNum = 0;//A中最少的人数。
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += A[i];
            if (temp * 2 >= sum) {
                mediumIndex = i;// 1,2=2 1,2,5= 5
                minNum = i - 1;
                break;
            }
        }
        BitSet bs = new BitSet(n);

        return 0;
    }
}
