package OJSolution.application.maths;

import java.util.LinkedList;
import java.util.Scanner;

class MultiRebbit {
    private LinkedList<Long> queue;//应该用边界值进行测试，是否需要用更长的数字存储

    long checkFn(int n) {
        queue = new LinkedList<>();
        queue.add((long) 1);
        queue.add((long) 2);
        int i = 2;
        long fi = 0;
        while (i < n) {
            fi = queue.poll() + queue.get(0);//此处可以用3个临时变量 a b sum 互相赋值代替，避免了容器的操作。
            queue.add(fi);
            i++;
            if (i == n) {
                return fi;
            }
        }
        return n;
    }
}

class Main4 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            MultiRebbit pr = new MultiRebbit();
            System.out.println(pr.checkFn(n));
        }
    }
}