package OJSolution.application.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Factors {

    private List<Integer> getPrime(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
                if (n == 1) {
                    return list;
                }
            }
        }
        return list;
    }

    private String toEqual(List<Integer> list) {
        String s = "";
        if (list.size() == 0) {
            return s;
        }
        s += list.get(0);
        for (int i = 1; i < list.size(); i++) {
            s += " * ";
            s += list.get(i);
        }
        return s;
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String factorEqul = n + " = ";
            List<Integer> list = getPrime(n);
            factorEqul += toEqual(list);
            System.out.println(factorEqul);
        }
    }
}