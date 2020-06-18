package OJSolution.application.maths;

import java.util.LinkedList;
import java.util.Scanner;

class NowCoderArray {
    private LinkedList<Integer> queue;

    String checkFn(int n) {
        queue = new LinkedList<>();
        queue.add(7);
        queue.add(11);
        int i = 1;
        int fi;
        while (i < n) {
            fi = queue.poll() + queue.get(0);
            queue.add(fi);
            i++;
            if (i == n) {
                if (fi % 3 == 0) {
                    return "Yes";
                }
            }
        }
        return "No";
    }
}

class Main2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            NowCoderArray pr = new NowCoderArray();
            System.out.println(pr.checkFn(n));
        }
    }
}