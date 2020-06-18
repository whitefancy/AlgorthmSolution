package OJSolution.application.maths;

import java.util.Scanner;

class NowCoderArray1 {
    private int[] concur = new int[]{1, 2, 0, 2, 2, 1, 0, 1};// i==0 <=> n%4==2

    String checkFn(int n) {
        int i = n % 8;
        if (concur[i] == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }
}

class Main3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            NowCoderArray1 pr = new NowCoderArray1();
            System.out.println(pr.checkFn(n));
        }
    }
}