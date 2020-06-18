package OJSolution.application.dynamicprofiling;

import java.util.Stack;

public class MoveStamp {
    private Stack<Integer> order;
    private String stamp;
    private StringBuffer target;

    public int[] movesToStamp(String stamp, String tar) {
        order = new Stack<>();
        int[] o = new int[0];
        this.stamp = stamp;
        target = new StringBuffer(tar);
        int si = 0, sj = stamp.length();
        for (int i = sj; i > 0; i--) {
            for (int j = 0; j + i <= sj; j++) {
                moveSP(j, j + i);
            }
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != '?') {
                return o;
            }
        }
        if (order.size() > 10) {
            return o;
        }
        o = new int[order.size()];
        int i = 0;
        while (!order.isEmpty()) {
            o[i++] = order.pop();
        }
        System.out.println(o.toString());
        return o;
    }

    private void moveSP(int spi, int spj) {
        if (spi == spj) {
            return;
        }
        String s1 = stamp.substring(spi, spj);
        int k = target.lastIndexOf(s1);
        while (k != -1) {
            if (k - spi < 0 || k + stamp.length() - spi > target.length()) {
                return;
            }
            order.add(k - spi);
            for (int i = 0; i < spj - spi; i++) {
                target.replace(k + i, k + i + 1, "?");
            }
            // target.replace(k,k+spj-spi,"?");
            k = target.lastIndexOf(s1);
        }
        // moveSP(spi+1,spj);
        //moveSP(spi,spj-1);
    }

    public void test() {

    }
}
