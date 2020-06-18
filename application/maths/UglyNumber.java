package OJSolution.application.maths;

import java.util.PriorityQueue;

/**
 * 查找第n个丑数，丑数是1，和2,3,5的倍数
 */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new UglyNumber().nthUglyNumber(10));
    }

    /**
     * 查找第n个丑数，丑数是1，和2,3,5的倍数
     * *bwftag  数学特性 质数  动态规划 状态未知
     *
     * @param n
     * @return
     */
    private int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        Long[] ugly = new Long[n];
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long p = 1;
        queue.add((long) 1);
        int i = 0;
        while (true) {
            addUgly(queue, p * 2);
            addUgly(queue, p * 3);
            addUgly(queue, p * 5);
            p = queue.poll();
            ugly[i++] = p;
            if (i == n) {
                break;
            }
        }
        return ugly[n - 1].intValue();
    }

    private void addUgly(PriorityQueue<Long> queue, long l) {
        if (!queue.contains(l)) {
            queue.offer(l);
        }
    }
}