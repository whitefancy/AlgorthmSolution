package OJSolution.uncategorized;

import java.util.LinkedList;

class RecentCounter {
    private LinkedList<Integer> queue;

    RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        int valid = t - 3000;
        while (queue.get(0) < valid) {
            queue.remove(0);
        }
        return queue.size();
    }
}