package OJSolution.application.linkedlist;

import OJSolution.datastructure.ListNode;

public class ListOperation {
    /**
     * 反转一个单链表。
     * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     * 进阶 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * *bwftag  链表反转 状态ok
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        return Reverse(head, next);
    }

    private ListNode Reverse(ListNode a, ListNode b) {
        if (b == null) {
            return a;
        }
        ListNode c = b.next;
        b.next = a;
        return Reverse(b, c);
    }

    public void test() {
        ListNode head = ListNode.ListGen("1->2->3->4->5->NULL");
        head = ListNode.ListGen("5->NULL");
        ListNode.ListOutput(reverseList(head));
    }
}
