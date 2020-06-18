package acmcoder;

import java.util.Scanner;

public class LajiCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] laji;
        n = sc.nextInt();
        int m = sc.nextInt();
        laji = new int[n + 1];
        int No = 0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            if (laji[a] == laji[b]) {
                laji[b] = laji[a] + 1;
            }

        }

        int[] cars = new int[n];
        for (int i = 1; i <= n; i++) {
            cars[laji[i]]++;
        }
        int max1 = 0, max2 = 0;
        for (int i = 0; i < n; i++) {
            if (cars[i] >= max1) {
                max2 = max2;
                max1 = cars[i];
            }
        }
        System.out.println(max2 * 2);
    }
}
