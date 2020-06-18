package OJSolution.application.maths;

import java.util.*;

public class MaxBenefit {
    //    求量，请你计算可以获得的最大收益是多少。
//
//    注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、
//            72、45亿元。如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得
// 72 + 45/2 = 94.5（亿元）。
    private double maxBenefit(List<Mooncake> list, int sell) {
        Collections.sort(list, new Comparator<Mooncake>() {
            @Override
            public int compare(Mooncake o1, Mooncake o2) {
                if (o1.value > o2.value) {
                    return -1;
                } else if (o1.value < o2.value) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        double income = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).count <= sell) {
                income += list.get(i).sum;
                sell -= list.get(i).count;
            } else {
                income += list.get(i).value * sell;
                sell = 0;
                break;
            }
        }
        return income;
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sell = sc.nextInt();
            List<Mooncake> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int count = sc.nextInt();
                Mooncake mk = new Mooncake(count);
                list.add(mk);
            }
            for (int i = 0; i < n; i++) {
                int sum = sc.nextInt();
                list.get(i).setSum(sum);
            }
            String ans = String.format("%.02f", maxBenefit(list, sell));
            System.out.println(ans);
        }
    }

    class Mooncake {
        int count;
        int sum;
        double value;

        Mooncake(int c) {
            count = c;
        }

        public void setSum(int s) {
            sum = s;
            value = 1.0 * sum / count;
        }
    }
}
