package OJSolution.uncategorized;

import java.util.Scanner;

public class Counter {
    private int first;
    private int end;
    private boolean[] chars;

    private Counter(boolean[] chars, int first, int end) {
        this.chars = chars;
        this.first = first;
        this.end = end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char[] chars = s.toCharArray();
        int n = chars.length;
        char a = chars[0];
        boolean[] chs = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == a) {
                chs[i] = true;
            } else {
                chs[i] = false;
            }
        }
        int max = 0;
        max = new Counter(chs, 0, n).count();
        System.out.print(max);

    }

    public int count() {
        if (first == end) {
            return 0;
        } else if ((end - first) % 2 == 0) {
            int task = new Counter(chars, first + 1, end).count();
            int task1 = new Counter(chars, first, end - 1).count();
            return Math.max(task, task1);
        }
        int tc = 0;
        int yc = 0;
        for (int i = first; i < end; i++) {
            if (chars[i]) {
                tc++;
            } else {
                yc++;
            }
        }
        if (tc == yc) {
            return 2 * yc;
        } else {
            int task = new Counter(chars, first + 1, end).count();
            int task1 = new Counter(chars, first, end - 1).count();
            return Math.max(task, task1);
        }
    }
}