package OJSolution.application.dynamicprofiling;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class PeeNut {

    public void test() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int K = sc.nextInt();
            if (K < 2) {
                System.out.println(0);
                continue;
            }
            LinkedList<Nut> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int count = sc.nextInt();
                    if (count != 0) {
                        Nut nut = new Nut(i, j, count);
                        list.add(nut);
                    }
                }
            }
            int sum = 0;
            CollectNut cn = new CollectNut();
            sum = cn.collectNuts(list, K);
            //System.out.print(p.powerfulIntegers(2,3,10));
            //System.out.print(p.powerfulIntegers(5,3,15));
            System.out.println(sum);
        }
    }

}

class Nut {
    int x;
    int y;
    int count;

    Nut(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class CollectNut {

    int collectNuts(LinkedList<Nut> list, int k) {
        int sum = 0;
        Collections.sort(list,
                new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Nut n1 = (Nut) o1;
                        Nut n2 = (Nut) o2;
                        if (n1.count > n2.count) {
                            return -1;
                        }
                        if (n1.count < n2.count) {
                            return 1;
                        }
                        return 0;
                    }
                });
        int curN = 0;
        Nut cur = new Nut(0, 0, 0);
        while (list.size() > 0 && k > 0) {
            Nut pre = cur;
            cur = list.poll();
            if (curN == 0) {
                k = k - cur.y;
            } else {
                k = k - abs(cur.x - pre.x);
                k = k - abs(cur.y - pre.y);
            }
            if (k - cur.y >= 0) {
                sum += cur.count;
                curN++;
            } else {
                return sum;
            }
        }
        return sum;
    }
}

//test case
/*
6 7 21
        0 0 0 0 0 0 0
        0 0 0 0 13 0 0
        0 0 0 0 0 0 7
        0 15 0 0 0 0 0
        0 0 0 9 0 0 0
        0 0 0 0 0 0 0

1 1 0
0

output 0

1 1 2
15
output 15

1 1 1
15
output 0
 */
