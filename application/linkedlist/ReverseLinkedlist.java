package OJSolution.application.linkedlist;

import java.util.*;


public class ReverseLinkedlist {
    /**
     * 给定一个常数K以及一个单链表L，
     * 请编写程序将L中每K个结点反转。
     * 例如：给定L为1→2→3→4→5→6，K为3，
     * 则输出应该为3→2→1→6→5→4；
     * 3→2→1→6→5→4；如果K为4，则输出应该为4→3→2→1→5→6，即最后不到K个元素不反转。
     * 输入时有的结点是无效的，并不在链表中，所以链表的元素个数要自行统计
     * *bwftag  链表反转 状态ok
     *
     * @param list
     * @param k
     */
    private void reverseList(List<Node> list, int k) {
        List<Node> ans = new LinkedList<>();
        int m = list.size() / k;
        for (int i = 0; i < m; i++) {
            for (int j = k - 1; j >= 0; j--) {
                Node cur = list.get(i * k + j);
                ans.add(cur);
            }
        }
        for (int i = m * k; i < list.size(); i++) {
            Node cur = list.get(i);
            ans.add(cur);
        }

        System.out.print(String.format("%05d", ans.get(0).adr) + " " + ans.get(0).val + " ");
        for (int i = 1; i < ans.size(); i++) {
            Node cur = ans.get(i);
            System.out.println(String.format("%05d", cur.adr));
            System.out.print(String.format("%05d", cur.adr) + " " + cur.val + " ");
        }
        System.out.println("-1");
    }

    public void test() {
        Map<Integer, Node> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int head = sc.nextInt();
        int len = sc.nextInt();
        int k = sc.nextInt();
        while (len-- > 0) {
            int adr = sc.nextInt();
            int val = sc.nextInt();
            int nxt = sc.nextInt();
            map.put(adr, new Node(adr, val, nxt));
        }
        Node cur = map.get(head);
        List<Node> list = new ArrayList<>();
        while (cur.nxt != -1) {
            list.add(cur);
            cur = map.get(cur.nxt);
        }
        list.add(cur);
        map = null;
        reverseList(list, k);
    }

    class Node {
        int adr;
        int val;
        int nxt;

        Node(int adr, int val, int nxt) {
            this.adr = adr;
            this.val = val;
            this.nxt = nxt;
        }

        public Node(int adr, int val) {
            this.adr = adr;
            this.val = val;
        }
    }
}
