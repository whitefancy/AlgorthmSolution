package OJSolution.application.sort;

import java.util.*;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * bwftag  数组规则 查找数对 状态AC
 */
public class AbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Comparator<Pair> order = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if ((o1.b - o1.a) == (o2.b - o2.a)) {
                    if (o1.a == o2.a) {
                        return o1.b - o2.b;
                    } else {
                        return o1.a - o2.a;
                    }
                } else {
                    return (o1.b - o1.a) - (o2.b - o2.a);
                }
            }
        };
        if (arr.length < 2) {
            return null;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(arr.length, order);
        for (int i = 0; i < arr.length - 1; i++) {
            Pair p = new Pair(arr[i], arr[i + 1]);
            queue.add(p);
        }
        int min = queue.peek().cha();
        List<List<Integer>> ans = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek().cha() == min) {
            Pair p = queue.poll();
            List<Integer> list = new ArrayList<>(2);
            list.add(p.a);
            list.add(p.b);
            ans.add(list);
        }
        return ans;
    }

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int cha() {
            return b - a;
        }
    }
}
