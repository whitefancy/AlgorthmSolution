package OJSolution.application.heap_priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeList {
    public static void main(String[] args) {
        ListNode[] A = new ListNode[3];
        for (int j = 0; j < 3; j++) {
            ListNode a = new ListNode(1);
            ListNode root = a;
            for (int i = 2; i < 5; i++) {
                ListNode k = new ListNode(i);
                a.next = k;
                a = k;
            }
            A[j] = root;
        }
        new MergeList().mergeKLists(A);
    }

    private ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> order = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<>(order);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            queue.offer(lists[i]);
            ListNode node = lists[i];
            while (node.next != null) {
                node = node.next;
                queue.offer(node);
            }
        }
        ListNode out = queue.poll();
        if (out == null) {
            return null;
        }
        ListNode first = new ListNode(out.val);
        ListNode pre = first;
        while (!queue.isEmpty()) {
            ListNode nxt = queue.poll();
            ListNode node = new ListNode(nxt.val);
            pre.next = node;
            pre = node;
        }
        return first;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
