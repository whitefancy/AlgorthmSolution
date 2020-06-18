package OJSolution.application.maths;

import java.util.Scanner;

public class PhraseNumber {
    //    如果一个数字从左边读和从右边读一样，那么这个数字就是一个回文数。例如32123就是一个回文数；17在某种意义上也是一个回文数，因为它的二进制型式——10001——是一个回文数。
//    请你帮忙开发一个程序，判断一个数n在任意进制（2-16）下是否有回文数。
    private boolean isPhrase(String s) {
        StringBuffer result = new StringBuffer(s);
        return result.reverse().toString().equals(s);
    }

    private String conversion(long n, int r) {
        String s = "";
        long cur = n;
        while (cur / r > 0) {
            s = rNum(cur % r) + s;
            cur = cur / r;
        }
        if (cur % r > 0) {
            s = rNum(cur % r) + s;
        }
        return s;
    }

    private String rNum(long l) {
        if (l < 10) {
            return "" + l;
        }
        return "" + (char) ('A' + l - 10);
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            if (isPhrase("" + n)) {
                System.out.println("Yes");
            } else {
                boolean flag = false;
                for (int i = 2; i < 17; i++) {
                    if (isPhrase(conversion(n, i))) {

                        System.out.println("Yes");
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    System.out.println("No");
                }
            }
        }
    }
}
