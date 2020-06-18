package OJSolution.application.linkedlist;

/**
 * 请编写函数，实现通过⼀次遍历找到链表中间节点；如果有两个中间节点，则请返回
 * 第⼆个中间节点（使⽤⾮递归⽅式）
 * 解法：快慢指针
 * 状态：AC
 */
public class FindMediumNode {
    public static void main(String[] args) {
        //偶数个节点
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        System.out.println(new FindMediumNode().middleNode(head).data);
        //奇数个节点
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.println(new FindMediumNode().middleNode(head1).data);
        //一个节点
        ListNode head2 = new ListNode(1, null);
        System.out.println(new FindMediumNode().middleNode(head2).data);
        //空节点
        System.out.println(new FindMediumNode().middleNode(null));
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}