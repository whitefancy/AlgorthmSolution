package OJSolution.application.hashvalue;

import java.util.*;

/**
 * 小明有一个花园，花园里面一共有m朵花，对于每一朵花，都是不一样的，小明用1～m中的一个整数表示每一朵花。
 * <p>
 * 他很喜欢去看这些花，有一天他看了n次，并将n次他看花的种类是什么按照时间顺序记录下来。
 * <p>
 * 记录用a[i]表示，表示第i次他看了a[i]这朵花。
 * <p>
 * 小红很好奇，她有Q个问题,问[l,r]的时间内，小明一共看了多少朵不同的花儿，小明因为在忙着欣赏他的花儿，所以想请你帮他回答这些问题。
 */
public class WatchFlower {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        int[] flowers;
        String key;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        flowers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            flowers[i] = sc.nextInt();
        }
        int h = sc.nextInt();
        for (int i = 0; i < h; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            if (s == e) {
                System.out.println(1);
                continue;
            } else {
                key = s + "-" + e;
            }
            if (map.containsKey(key)) {
                System.out.println(map.get(key));
            } else {
                int sum = 0;
                Set<Integer> set = new HashSet<>();
                for (int j = s; j <= e; j++) {
                    set.add(flowers[j]);
                }
                System.out.println(set.size());
                map.put(key, set.size());
            }
        }
    }
}
