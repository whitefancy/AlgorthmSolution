package OJSolution.application.heap_priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class SortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        ListNode next = new ListNode(2);
        root.next = next;
        next = new ListNode(1);
    }

    public ListNode sortList(ListNode head) {
        Comparator<ListNode> order = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue queue = new PriorityQueue(order);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null) {
            queue.offer(p);
            p = p.next;
        }
        ListNode ans = (ListNode) queue.poll();
        ListNode q = ans;
        while (!queue.isEmpty()) {
            p = (ListNode) queue.poll();
            q.next = p;
            q = p;
        }
        p.next = null;
        return ans;
    }
}
