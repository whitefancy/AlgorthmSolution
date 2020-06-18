package OJSolution.application.maths;

import java.util.Scanner;

public class DigitalClassification {


    public void test() {
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        int n = sc.nextInt();
        int A1 = 0;
        int A2 = 0, ad = 1;
        int A3 = 0;
        double A4 = 0;
        int A5 = 0;
        int[] exist = new int[5];
        while (n-- > 0) {
            int A = sc.nextInt();
            switch (A % 5) {
                case 0:
                    if (A % 2 == 0) {
                        A1 += A;
                        exist[0]++;
                    }
                    break;
                case 1:
                    A2 += A * ad;
                    ad *= -1;
                    exist[1]++;
                    break;
                case 2:
                    exist[2]++;
                    A3++;
                    break;
                case 3:
                    A4 += A;
                    exist[3]++;
                    break;
                case 4:
                    if (A > A5) {
                        A5 = A;
                    }
                    exist[4]++;
                    break;
            }
        }
        String ans = "";
        if (exist[0] != 0) {
            ans += A1;
        } else {
            ans += "N";
        }
        ans += " ";
        if (exist[1] != 0) {
            ans += A2;
        } else {
            ans += "N";
        }
        ans += " ";
        if (exist[2] != 0) {
            ans += A3;
        } else {
            ans += "N";
        }
        ans += " ";
        if (exist[3] != 0) {
            A4 = A4 / exist[3];
            ans += String.format("%.1f", A4);
        } else {
            ans += "N";
        }
        ans += " ";
        if (exist[4] != 0) {
            ans += A5;
        } else {
            ans += "N";
        }

        System.out.println(ans);
    }
}
