package Algorithm.basicKnowledge.dataStructure.String;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 通过
 */
public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode main, other;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            main = l1;
            other = l2;
        } else {
            main = l2;
            other = l1;
        }
        ListNode head = main;
        ListNode pre = null;
        ListNode pre1 = null;
        while (null != main && null != other) {
            while (null != main && main.val <= other.val) {
                pre = main;
                main = main.next;
            }
            pre.next = other;
            if (null == main) {
                break;
            }
            while (null != other && other.val <= main.val) {
                pre1 = other;
                other = other.next;
            }
            pre1.next = main;
            pre = pre1;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
