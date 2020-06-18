package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation {
    /**
     * 执行结果：
     * 通过
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("*");
        set.add("/");
        set.add("+");
        set.add("-");
        int ans = 0;
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            if (!set.contains(s)) {
                stack.push(Integer.parseInt(s));
            }
            if (set.contains(s)) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    /**
     * 快4ms 原来10ms，现在6ms
     *
     * @param tokens
     * @return
     */
    public int evalRPN1(String[] tokens) {
        int ans = 0;
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        Integer a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            switch (s) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
