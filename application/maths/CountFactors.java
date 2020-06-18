package OJSolution.application.maths;

import java.util.Scanner;

public class CountFactors {

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(countFactor(n));
        }
    }

    private int countFactor(int n) {
        int count = 0;
        int cur = n;
        for (int k = 2; k <= cur; ) {
            if (cur % k == 0) {
                count++;
                cur = cur / k;
                if (cur == 1) {
                    return count;
                }
            }
            while (cur % k == 0) {
                cur = cur / k;
                if (cur == 1) {
                    return count;
                }
            }
            k++;
        }
        return -1;
    }
}
