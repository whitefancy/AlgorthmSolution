package OJSolution.application.maths;

import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {
    private void showKaprekar(int n) {
        String s = String.format("%04d", n);
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        s = String.copyValueOf(chs);
        int min = Integer.valueOf(s);
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        int max = Integer.valueOf(sb.toString());
        int cur = max - min;
        if (cur != 0 && cur != 6174) {
            String ans = String.format("%04d", max) + " - " + String.format("%04d", min) + " = " + String.format("%04d", cur);
            System.out.println(ans);
            showKaprekar(cur);
        } else {
            String ans = String.format("%04d", max) + " - " + String.format("%04d", min) + " = " + String.format("%04d", cur);
            System.out.println(ans);
        }
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            showKaprekar(n);
        }
    }
}
