package OJSolution.datastructure;

import java.util.HashMap;
import java.util.Map;

class MyHashSet {

    /**
     * Initialize your data structure here.
     */
    private Map<Integer, Integer> map;

    public MyHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, 1);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
