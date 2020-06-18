package OJSolution.application.dynamicprofiling;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MoveStampNew {
    private List<Integer> list;
    private StringBuffer s1;
    private String stamp;
    private StringBuffer target;
    private int sta_len;

    private int[] movesToStamp(String sta, String tar) {
        list = new LinkedList<>();
        int[] order = new int[0];
        stamp = sta;
        sta_len = sta.length();
        target = new StringBuffer(tar);
        for (int i = sta_len; i > 0; i--) {
            for (int j = 0; j + i <= sta_len; j++) {
                moveSP(j, j + i);
            }
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != '?') {
                return order;
            }
        }
        if (list.size() > 10) {
            return order;
        }
        order = new int[list.size()];
        int i = 0;
        Collections.reverse(list);
        int[] ints = list.stream().mapToInt((Integer in) -> in).toArray();
        return ints;
    }

    private void moveSP(int spi, int spj) {
        if (spi == spj) {
            return;
        }
        s1 = new StringBuffer(stamp);
        for (int i = 0; i < stamp.length(); i++) {
            if (i < spi || i >= spj) {
                s1.replace(i, i + 1, "?");
            }
        }
        int k = target.lastIndexOf(s1.toString());
        while (k != -1) {
            list.add(k);
            for (int i = 0; i < sta_len; i++) {
                target.replace(k + i, k + i + 1, "?");
            }
            k = target.lastIndexOf(s1.toString());
        }
    }

    public void test() {
        int[] ans = movesToStamp("abca", "aabcaca");//        [0, 3, 1]
        List list = Arrays.asList(ans);
        assert list.toString().equals("[0, 3, 1]") : "wrong answer";
        ans = movesToStamp("oz", "ooozz");//[3, 0, 1, 2]
        list = Arrays.asList(ans);
        assert list.toString().equals("[0, 3, 1]") : "wrong answer" + list.toString();
        ans = movesToStamp("aye", "eyeye");//[]
        ans = movesToStamp("cab", "cabbb");//[2, 1, 0]
        list = Arrays.asList(ans);
        assert list.toString().equals("[0, 3, 1]") : "wrong answer" + list.toString();
        ans = movesToStamp("uskh", "uskhkhhskh");//[5,4,6,3,1,2,0]
        list = Arrays.asList(ans);
        assert list.toString().equals("[0, 3, 1]") : "wrong answer" + list.toString();
    }
}
