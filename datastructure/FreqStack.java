package OJSolution.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 输出出现频率最高的元素的栈
 * bwftag 数据结构
 */
public class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    private int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        if (f > maxfreq) {
            maxfreq = f;
        }
        freq.put(x, f);
        group.computeIfAbsent(f, z -> new Stack<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0) {
            maxfreq--;
        }
        return x;
    }
}
