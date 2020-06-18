package OJSolution.application.maths;

import java.util.Arrays;

public class SwapCandy {
    public void test() {
        int[] A = new int[]{32, 38, 8, 1, 9};
        int[] B = new int[]{68, 92};
        int[] C = fairCandySwap(A, B);
        System.out.println(C.toString());
    }

    private int[] fairCandySwap(int[] A, int[] B) {
        int S1 = 0, S2 = 0;
        for (int i = 0; i < A.length; i++) {
            S1 += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            S2 += B[i];
        }
        int change = 0;
        change = (S1 - S2) / 2;
        int[] Sm, La;
        Arrays.sort(A);
        Arrays.sort(B);
        if (S1 < S2) {
            change = change * (-1);
            La = B;
            Sm = A;
        } else {
            La = A;
            Sm = B;
        }
        int[] ans = new int[2];
        for (int i = 0; i < Sm.length; i++) {
            for (int j = La.length - 1; j >= 0; j--) {
                if (La[j] - Sm[i] == change) {

                    if (S1 < S2) {
                        ans[0] = Sm[i];
                        ans[1] = La[j];
                    } else {
                        ans[1] = Sm[i];
                        ans[0] = La[j];
                    }
                    return ans;
                } else if (La[j] - Sm[i] < change) {
                    break;
                }
            }
        }
        return ans;
    }
}
