package OJSolution.application.maths;

import java.util.Arrays;

public class Perimeter {
    //    给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
//
//    如果不能形成任何面积不为零的三角形，返回 0。
    private int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] - A[i - 1] < A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    public void test() {
        int[] A;
        int ans;
        A = new int[]{2, 1, 2};
        System.out.println(largestPerimeter(A));
        A = new int[]{1, 2, 1};
        System.out.println(largestPerimeter(A));
        A = new int[]{3, 2, 3, 4};
        System.out.println(largestPerimeter(A));
        A = new int[]{3, 6, 2, 3};
        System.out.println(largestPerimeter(A));
    }
}
