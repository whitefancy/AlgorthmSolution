package OJSolution.application.findfromarray;

import java.util.*;

/**
 * 给定一个数组，求所有的逆序对的距离和
 * 逆序对即降序
 * 例如 1 3 4 2 逆序对为3 2 ，4 2 所以和是3
 * * *bwftag  数组规则 查找数对 状态AC 60% 算法复杂度过大
 */
public class NixuPairSum1 {
    public static void main(String[] args) {

        int n = 100000;
        Integer[] A = new Integer[n];
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        List<Integer> B = Arrays.asList(A);
        Collections.shuffle(B);
        int[] A1 = new int[n];
        for (int i = 0; i < n; i++) {
            A1[i] = B.get(i);
        }
        System.out.println(new NixuPairSum1().NixuSum(n, A1));
    }

    public static void main1(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            System.out.println(new NixuPairSum1().NixuSum(n, A));
        }
    }

    private long NixuSum(int n, int[] A) {
        long count = 0;
        Comparator<Pair> order = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        //Pair key index value value
        PriorityQueue<Pair> queue = new PriorityQueue<>(n, order);
        List<Pair> list = new LinkedList<>();
        Pair a = new Pair(0, A[0]);
        queue.offer(a);
        for (int i = 1; i < n; i++) {
            while (!queue.isEmpty() && A[i] < queue.peek().getValue()) {
                a = queue.poll();
                int p = a.getKey();
                count = count + i - p;
                list.add(a);
            }
            a = new Pair(i, A[i]);
            queue.offer(a);
            if (list.size() > 0) {
                queue.addAll(list);
                list.clear();
            }
        }
        return count;
    }
}

class Pair {
    private int key;
    private int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
