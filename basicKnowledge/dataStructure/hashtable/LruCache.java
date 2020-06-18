package Algorithm.basicKnowledge.dataStructure.hashtable;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * LinkedHashMap是通过比HashMap多了一个双向链表实现的有序。
 * <p>
 * 1.按照插入顺序遍历
 * <p>
 * 2.按照访问顺序遍历
 * <p>
 * 按照访问顺序遍历时，每次访问完map中的元素后，会将该元素置入map的最后一位，
 * 执行结果：
 * 通过
 */
public class LruCache {
    LinkedHashMap<Integer, Integer> map;
    int cap = 0;

    public LruCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        cap = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            return;
        }
        Integer oldkey = 0;
        if (map.size() == cap) {
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
                oldkey = (Integer) iterator.next();
                break;
            }
            map.remove(oldkey);
        }
        map.put(key, value);
    }
}
