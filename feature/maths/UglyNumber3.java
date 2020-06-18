package OJSolution.feature.maths;

import java.util.PriorityQueue;


/**
 * 查找第n个丑数，丑数是1，和可以被a,b,c整除的的倍数
 * *bwftag  数学特性 特殊数  状态占内存太多 outofMemory
 */
public class UglyNumber3 {
    public static void main(String[] args) {
        System.out.println(new UglyNumber3().nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    private int nthUglyNumber(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        int[] ugly = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int p = 1;
        int i = 0;
        int k = Integer.MAX_VALUE;
        while (true) {
            addUgly(queue, p * a % k);
            addUgly(queue, p * b % k);
            addUgly(queue, p * c % k);
            int q = queue.poll();
            p++;
            ugly[i++] = q;
            if (i == n) {
                break;
            }
        }
        return ugly[n - 1];
    }

    private void addUgly(PriorityQueue<Integer> queue, int l) {
        if (!queue.contains(l)) {
            queue.offer(l);
        }
    }
}