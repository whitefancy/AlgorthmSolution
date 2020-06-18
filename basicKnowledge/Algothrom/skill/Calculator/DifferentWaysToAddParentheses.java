package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

import java.util.*;

/**
 * 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 * <p>
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * <p>
 * 执行结果：
 * 通过
 */
public class DifferentWaysToAddParentheses {
    List<Integer>[][] memory;//第 i到j的组合的结果数量
    int n;
    List<Integer> nums = new ArrayList<>();
    List<Character> ops = new ArrayList<>();

    /**
     * 一看到题就觉得有点复杂，可以考虑一下递归的方式，去寻找子问题和原问题解的关系。
     * <p>
     * 可以通过运算符把整个式子分成两部分，两部分再利用递归解决。
     * 然后还需要递归出口。
     * <p>
     * 如果给定的字符串只有数字，没有运算符，那结果就是给定的字符串转为数字。
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<>();
        splitString(input);
        n = nums.size();
        memory = new ArrayList[n][n];
        return diffWaysToCompute(0, n - 1);
    }

    void splitString(String s) {
        int m = 0;
        int n1 = s.length();
        for (int i = 0; i < n1; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                m = m * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == n1 - 1) {
                nums.add(m);
                if (i != n1 - 1) {
                    ops.add(c);
                }
                m = 0;
            }
        }
    }

    List<Integer> diffWaysToCompute(int l, int r) {
        if (null != memory[l][r]) {
            return memory[l][r];
        }
        List<Integer> list = new ArrayList<>();
        if (l == r) {
            list.add(nums.get(l));
            memory[l][r] = list;
            return list;
        }
        for (int i = l; i < r; i++) {
            List<Integer> left = diffWaysToCompute(l, i);
            List<Integer> right = diffWaysToCompute(i + 1, r);
            for (Integer l0 : left) {
                for (Integer r0 : right) {
                    int ans = cul(l0, r0, ops.get(i));
                    list.add(ans);
                }
            }
        }
        memory[l][r] = list;
        return memory[l][r];
    }

    int cul(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
}
