package OJSolution.application.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 大锤发年终奖，
 * 年龄大的要比年龄小的发的多
 * 最少发一百，100累加，相邻的知道对方的年终奖
 * 求最少发多少
 * *bwftag  数组规则 状态未知
 */
public class dachui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> years = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                years.add(sc.nextInt());
            }
            int min = Collections.min(years);
            int minin = years.indexOf(min);
            int cur = years.get(0);
            int[] bonus = new int[n];
            bonus[0] = 0;
            for (int i = 1; i < years.size(); i++) {
                if (years.get(i) > years.get(i - 1)) {
                    bonus[i] = bonus[i - 1] + 1;
                } else if (years.get(i) < years.get(i - 1)) {
                    bonus[i] = bonus[i - 1] - 1;
                } else {
                    bonus[i] = bonus[i - 1];
                }
            }
            int tmindex = bonus[minin];
            long count = 0;
            for (int i = 0; i < bonus.length; i++) {
                count += (bonus[i] - tmindex + 1) * 100;
            }
            System.out.println(count);
        }
    }
}
