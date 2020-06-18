package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 */
public class CalculatorIcci {
    public static void main(String[] args) {
        System.out.println(new CalculatorIcci().calculate("3/2"));
        Set<String> st = new HashSet<>();
    }

    /**
     * 普通计算器，且都为整数，我们主要操作是，遇到+-就将数入栈，遇到乘除就将数字出栈计算后再入栈。有几个容易混淆的点：
     * 1.判断的op是当前num的前一个计算符，我们是假设num后面出现了操作符，然后再去判断num前面的操作符是什么：
     * 1.1如果num前面的是+或者-，我们就将num入栈，其中如果是-号，我们就将-num入栈，要记住，switch比的操作符是num前面的而不是
     * 当前的char c=s.charAt(i)。
     * 1.2如果是* /，我们就将栈中存放的num前面一个数字出栈，用该数字和num进行运算，将运算后的数字继续入栈。
     * 每次操作完后我们将num=0，op=s.charAt(i)。
     * <p>
     * 执行结果：
     * 通过
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.trim() == "") {
            throw new IllegalArgumentException("表达式不能为空");
        }
        s = s.replace(" ", "");
        Stack<Integer> nums = new Stack<>();
        int n = s.length();
        int m = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                m = m * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == n - 1) {
                int t = 0;
                switch (op) {
                    case '+':
                        nums.push(m);
                        break;
                    case '-':
                        nums.push(-m);
                        break;
                    case '*':
                        t = nums.pop();
                        nums.push(m * t);
                        break;
                    case '/':
                        t = nums.pop();
                        nums.push(t / m);
                        break;
                }
                op = c;
                m = 0;
            }
        }
        int ans = 0;
        while (!nums.isEmpty()) {
            m = nums.pop();
            ans += m;
        }
        return ans;
    }

    /**
     * 简化一定的运算
     *
     * @param s
     * @return
     */
    public int calculate1(String s) {
        s = s.replace(" ", "");
        int m = 0;
        int n = s.length();
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                m = m * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == n - 1) {
                switch (op) {
                    case '+':
                        stack.push(m);
                        break;
                    case '-':
                        stack.push(-m);
                        break;
                    case '*':
                        stack.push(stack.pop() * m);
                        break;
                    case '/':
                        stack.push(stack.pop() / m);
                        break;
                }
                op = c;
                m = 0;
            }
        }
        while (!stack.isEmpty()) {
            m += stack.pop();
        }
        return m;
    }
}
