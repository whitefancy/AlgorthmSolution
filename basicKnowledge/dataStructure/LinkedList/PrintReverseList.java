package Algorithm.basicKnowledge.dataStructure.LinkedList;


import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class PrintReverseList {
    /**
     * 先反转链表再打印
     * 执行结果：
     * 通过
     * 执行用时 :
     * 0 ms
     * ,
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int count = 0;
        if (head == null) {
            return new int[0];
        }
        ListNode prior = null;
        ListNode now = head;
        ListNode after = head.next;
        while (null != now) {
            count++;
            now.next = prior;
            prior = now;
            now = after;
            if (null != now) {
                after = now.next;
            }
        }
        int[] ans = new int[count];
        int i = 0;
        while (prior != null) {
            ans[i++] = prior.val;
            prior = prior.next;
        }
        return ans;
    }

    /**
     * 解法2 使用栈来临时存储数据
     * 执行结果：
     * 通过
     * 执行用时 :
     * 2 ms
     * ,
     *
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        int count = 0;
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        ListNode now = head;
        while (null != now) {
            count++;
            stack.push(now.val);
            now = now.next;
        }
        int[] ans = new int[count];
        int i = 0;
        while (i < count) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
