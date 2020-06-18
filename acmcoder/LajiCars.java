package acmcoder;

import java.util.Scanner;

/**
 * 最近很多城市都搞起了垃圾分类，已知有一个小区有n堆垃圾需要丢弃，这些垃圾都打包了，我们并不知道这是什么垃圾，要知道有些垃圾如果丢在一起是会影响环境的。这个小区一共只有两辆垃圾车，出于合理负载的考量，要求两辆车必须装载相同数量的垃圾。我们希望在不影响环境的情况下，每次让垃圾车载走最多的垃圾。
 * <p>
 * 我们为垃圾袋标了号，分别是1-n，有m个约束，每个约束表示为“a b”，意思是第a堆垃圾与第b堆垃圾不能装在一辆垃圾车上。（每堆垃圾最多有两个约束条件）
 * <p>
 * 请问两辆垃圾车一次最多可以带走多少堆垃圾呢？
 */
public class LajiCars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] laji = new int[n + 1];
        int m = sc.nextInt();
        int[][] nots = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            nots[i][0] = a - 1;
            nots[i][1] = b - 1;
        }
        System.out.println(LajiCars.maxMove(n, nots));
    }

    private static int maxMove(int n, int[][] nots) {
        return (n - nots.length + 1);
    }
}
