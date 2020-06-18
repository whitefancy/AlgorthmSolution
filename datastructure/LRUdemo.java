package OJSolution.datastructure;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Queue;

/**
 * 模拟缓存区，最近最不常使用的先出
 * *bwftag 换页机制 数据结构 状态ok
 */
public class LRUdemo {
    private int max;
    private LinkedHashMap<Integer, Integer> map;

    /**
     * @param capacity 缓存区大小
     */
    private LRUdemo(int capacity) {
        max = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public static void main(String[] args) {
        LRUdemo cache = new LRUdemo(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
        ArrayDeque<Integer> queue = new ArrayDeque<>(10);
        StringBuilder sb;

    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if (value != -1) {
            map.remove(key);
            map.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        int old = map.getOrDefault(key, -1);
        if (old == -1 && map.size() == max) {
            int oldkey = map.entrySet().iterator().next().getKey();
            map.remove(oldkey);
        }
        map.put(key, value);
    }
}