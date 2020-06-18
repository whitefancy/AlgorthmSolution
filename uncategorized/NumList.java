package OJSolution.uncategorized;

import java.util.Arrays;
import java.util.Scanner;

public class NumList {
    public static void main(String[] args) {
        //二分查找
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int k = Arrays.binarySearch(A, x);
            while (A[k - 1] == x) {
                k--;
            }
            System.out.println(n - k);
            for (int j = k; j < n; j++) {
                A[j] = A[j] - 1;
            }
        }
    }
}
