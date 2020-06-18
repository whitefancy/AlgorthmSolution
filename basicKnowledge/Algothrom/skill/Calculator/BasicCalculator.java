package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * <p>
 * 基本计算器
 */
public class BasicCalculator {
    /**
     * 我们将表达式的元素一个接一个的添加到栈上，直到我们遇到一个右括号 )。然后逐个弹出栈中的元素，在运行时对子表达式进行求值，直到遇到左括号 ( 为止。
     * 我们需要注意的是给定的表达式会很复杂，即会有嵌套在其他表达式的表达式。即 (A - (B - C))，我们需要 B-C 外面的 - 号与 B-C 关联起来，而不是仅仅与 B 关联起来。
     * <p>
     * 执行结果：
     * 通过
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = s.replace(" ", "");
        s = processString(s);
        int m = 0;
        int n1 = s.length();
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n1; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                m = m * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == n1 - 1) {
                switch (op) {
                    case '+':
                        stack.push(m);
                        break;
                    case '-':
                        stack.push(-m);
                        break;
                }
                op = c;
                m = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    String processString(String s) {
        int n1 = s.length();
        Stack<Character> stack = new Stack<>();
        char op = '+';
        stack.push('+');
        boolean rev = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                switch (c) {
                    case '(':
                        stack.push(op);
                        break;
                    case ')':
                        stack.pop();
                        break;
                    case '+':
                        if ('+' == stack.peek()) {
                            op = '+';
                        } else {
                            op = '-';
                        }
                        sb.append(op);
                        break;
                    case '-':
                        op = '-';
                        if ('+' == stack.peek()) {
                            op = '-';
                        } else {
                            op = '+';
                        }
                        sb.append(op);
                        break;
                }
            }
        }
        return sb.toString();
    }
}
