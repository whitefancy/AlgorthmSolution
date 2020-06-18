package OJSolution.application.maths;

import java.util.Scanner;

public class AddEqual {
    //    给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
    private boolean Equal(long a[]) {
        int flag = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i] >= 0) {
                flag++;
            } else {
                flag--;
            }
        }
        if (flag == -3 || flag == 3) {
            return a[2] - a[1] < a[0];
        } else if ((a[0] > 0 && a[1] < 0) || (a[0] < 0 && a[1] > 0)) {
            return a[0] + a[1] > a[2];
        } else if (a[2] < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        int n = sc.nextInt();
        int k = 1;
        while (n-- > 0) {
            long[] A = new long[3];
            for (int i = 0; i < 3; i++) {
                A[i] = sc.nextLong();
            }
            String ans = "Case #" + k + ": " + Equal(A);
            System.out.println(ans);
            k++;
        }
    }
}
