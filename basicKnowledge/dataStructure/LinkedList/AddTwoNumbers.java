package Algorithm.basicKnowledge.dataStructure.LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode ans = null;
        ListNode pre = ans;
        while (true) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int c = a + b + temp;
            if (c == 0 && l1 == null && l2 == null) {
                break;
            }
            ListNode node = new ListNode(c % 10);
            if (ans == null) {
                ans = node;
                pre = ans;
            } else {
                pre.next = node;
                pre = node;
            }

            if (a + b + temp >= 10) {
                temp = 1;
            } else {
                temp = 0;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
