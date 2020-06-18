package Algorithm.basicKnowledge.dataStructure.LinkedList;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 执行结果：
 * 通过
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a1 = headA;
        ListNode b1 = headB;
        int miss = 0;
        if (a1 == null || b1 == null) {
            return null;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
            if (headA == null) {
                headA = b1;
                miss++;
            }
            if (headB == null) {
                headB = a1;
            }
            if (miss == 2) {
                return null;
            }
        }
        return headB;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
