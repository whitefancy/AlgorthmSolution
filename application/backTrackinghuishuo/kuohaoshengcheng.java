package OJSolution.application.backTrackinghuishuo;

import java.util.LinkedList;
import java.util.List;

class kuohaoshengcheng {
    public static void main(String[] args) {
        List<String> ans = new kuohaoshengcheng().generateParenthesis(3);
        for (String a : ans) {
            System.out.println(a);
        }
    }

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * *bwftag  字符串生成 回溯 规则 状态ok
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if (n < 1) {
            ans.add("");
            return ans;
        }
        char[] now = new char[n * 2];
        backTracking(ans, n, 0, 0, now, 0);
        return ans;
    }

    private void backTracking(List<String> ans, int n, int left, int right, char[] now, int k) {
        if (right == n) {
            ans.add(String.valueOf(now));
            return;
        }
        if (left < n) {
            now[k] = '(';
            backTracking(ans, n, left + 1, right, now, k + 1);
        }
        if (right < left) {
            now[k] = ')';
            backTracking(ans, n, left, right + 1, now, k + 1);
        }
    }
}