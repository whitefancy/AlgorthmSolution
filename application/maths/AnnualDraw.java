package OJSolution.application.maths;

import java.util.Scanner;

public class AnnualDraw {
    //错排问题

    //    今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
//            1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
//            2. 待所有字条加入完毕，每人从箱中取一个字条；
//            3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
//    现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
//    当n个编号元素放在n个编号位置，元素编号与位置编号各不对应的方法数用D(n)表示，那么D(n-1)就表示n-1个编号元素放在n-1个编号位置，各不对应的方法数，其它类推.
//
//            第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法;
//
//    第二步，放编号为k的元素，这时有两种情况:⑴把它放到位置n，那么，对于剩下的n-1个元素，由于第k个元素放到了位置n，剩下n-2个元素就有D(n-2)种方法;⑵第k个元素不把它放到位置n，这时，对于这n-1个元素，有D(n-1)种方法;
//
//    综上得到
//
//    D(n) = (n-1) [D(n-2) + D(n-1)]
//  全排列为n！ 故p = D(n)/n!
//    特殊地，D(1) = 0, D(2) = 1.
    private double draw(int n) {
        long factorial = 1;
        double p = 1;
        long a = 0, b = 1;
        long dn = 1;
        for (int i = 2; i < n; i++) {
            dn = i * (a + b);
            a = b;
            b = dn;
            factorial *= i;
        }
        return dn * 1.0 / (factorial * n);
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String ans = String.format("%.2f", draw(n) * 100);
            System.out.println(ans + "%");
        }
    }
}
