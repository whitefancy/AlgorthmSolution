package Algorithm.basicKnowledge.Algothrom.skill.Calculator;

import java.util.ArrayList;
import java.util.Stack;

public class MyCalculator {

    public static void main(String[] args) {
        String obj = "6+(8/2)+6/3+1*8 + 30";
        ArrayList<String> arrayList = MyCalculator.strFormat(obj);
        System.out.println(obj + "=" + MyCalculator.calculator(arrayList));
    }


    /**
     * 采用后续表达式计算结果
     * 1、当前字符串为数字时，直接入栈
     * 2、当前字符串为计算符时，取出栈中的前两个计算
     * 3、将计算结果再放入到栈中，栈中最后剩余的一个元素就是要求的结果
     */
    private static int calculator(ArrayList<String> obj) {
        ArrayList<String> result = MyCalculator.transform(obj);
        System.out.println(result);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < result.size(); i++) {
            String symbol = result.get(i);
            if (MyCalculator.isDigital(symbol)) { //数字直接入栈
                stack.push(Integer.parseInt(symbol));
            } else { // 处理操作符
                int num1, num2;
                num1 = stack.pop(); //取出两个数
                num2 = stack.pop();
                switch (symbol) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }

    /**
     * 中序遍历改为后续遍历
     */
    private static ArrayList<String> transform(ArrayList<String> arrayList) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();
        for (int index = 0; index < arrayList.size(); index++) {
            String symbol = arrayList.get(index);
            if (MyCalculator.isDigital(symbol)) { //如果是数字直接输出
                result.add(symbol);
            } else if (symbol.equals(")")) {
                String tmp;
                while (!(tmp = stack.pop()).equals("(")) { // 匹配成功后停止
                    result.add(tmp);
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(symbol);
                    continue;
                }
                String tmp = stack.peek();
                while (MyCalculator.outPriority(symbol) <= MyCalculator.inPriority(tmp)) { //优先级小于栈内优先级，一直出栈
                    result.add(tmp);
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    tmp = stack.peek();
                }
                stack.push(symbol);
            }
        }
        //将剩余的出栈
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 首先对String 进行格式化 转化成ArrayList
     *
     * @param src 3*5+8;
     * @return ArrayList 3 * 5 + 8
     */
    private static ArrayList<String> strFormat(String src) {
        if (src == null || src.equals("")) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder comChar = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            if (ch == ' ') {
                continue; //去除空格
            }
            if (!Character.isDigit(ch)) {
                if (!comChar.toString().trim().equals("")) {
                    arrayList.add(comChar.toString().trim());
                    comChar.delete(0, comChar.length());
                }
                arrayList.add(ch + "");
                continue;
            }
            comChar.append(ch);
        }
        if (!comChar.toString().trim().equals("")) {
            arrayList.add(comChar.toString().trim());
        }
        return arrayList;
    }

    /**
     * 判断是否为数字
     *
     * @param symbol 782 或者 + - * /
     * @return true or false
     */
    private static boolean isDigital(String symbol) {
        return !symbol.equals("+") && !symbol.equals("-")
                && !symbol.equals("*") && !symbol.equals("/")
                && !symbol.equals("(") && !symbol.equals(")");
    }

    private static int inPriority(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 4;
            case ")":
                return 7;
            case "(":
                return 1;
            default:
                return 0;
        }
    }

    private static int outPriority(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 3;
            case "*":
            case "/":
                return 5;
            case ")":
                return 1;
            case "(":
                return 7;
            default:
                return 0;
        }
    }
}
