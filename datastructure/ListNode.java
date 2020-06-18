package OJSolution.datastructure;

/**
 * 链表数据结构
 */
public class ListNode {
    public ListNode next;
    private int val;

    private ListNode(int x) {
        val = x;
    }

    /**
     * 将链表字符串转化成链表结构
     * *bwftag 链表工具
     *
     * @param list 1->2->4->5->NULL
     * @return 链表的头结点，有值的
     */
    public static ListNode ListGen(String list) {
        String[] vals = list.split("->");
        ListNode head = null;
        if (vals.length < 2) {
            return head;
        }
        head = new ListNode(Integer.valueOf(vals[0]));
        ListNode cur = head;
        for (int i = 1; i < vals.length - 1; i++) {
            ListNode node = new ListNode(Integer.valueOf(vals[i]));
            cur.next = node;
            cur = node;
        }
        return head;
    }

    /**
     * 将链表输出成字符串并打印
     * bwftag 链表工具
     *
     * @param head ListNode
     * @return 链表字符串 1->2->4->5->NULL
     */
    public static String ListOutput(ListNode head) {
        if (head == null) {
            System.out.println("NULL");
        } else {
            System.out.print(head.val + "->");
            String s = head.val + "->";
            s += ListNode.ListOutput(head.next);
        }
        return "NULL";
    }
}
