package OJSolution.feature.string;

import java.util.Scanner;

public class bireverseString {
    private boolean biString(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        StringBuffer sb = new StringBuffer(s);
        if (!sb.reverse().toString().equals(s)) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (biString(s)) {
                String s1 = "";
                for (int i = 0; i < s.length() - 1; i += 2) {
                    s1 += s.charAt(i);
                }
                System.out.println(s1);
            } else {
                System.out.println(false);
            }
        }
    }
}
