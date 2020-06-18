package OJSolution.application.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CombineMinNum {
    //    给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
//    给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
//
//    现给定数字，请编写程序输出能够组成的最小的数。
    private String combineMin(List<Integer> list, int zeroN) {
        Collections.sort(list);
        String s = "" + list.get(0);
        for (int i = 0; i < zeroN; i++) {
            s += "0";
        }
        for (int i = 1; i < list.size(); i++) {
            s += list.get(i);
        }
        return s;
    }

    public void test() {
        List<Integer> list = new ArrayList<>();
        int n = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            for (int i = 0; i < nums.length; i++) {
                int r = Integer.valueOf(nums[i]);
                if (r == 0) {
                    n++;
                } else {
                    list.add(r);
                }
            }
            System.out.println(combineMin(list, n));
        }
    }
}
