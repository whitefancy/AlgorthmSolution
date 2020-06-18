package Algorithm.basicKnowledge.dataStructure.queueStack;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 执行结果：
 * 通过
 */
public class Stack2Queue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public Stack2Queue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
        return s2.pop();
    }
}
