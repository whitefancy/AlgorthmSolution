package OJSolution.uncategorized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PowerPuke {
    public static void main(String[] args) {
        //   P = 10,V= [13]
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = s.substring(4, s.length());
        String[] ss = s.split(",V= ");
        int P = Integer.valueOf(ss[0]);
        String[] Vs = ss[1].substring(1, ss[1].length() - 1).split(",");
        int[] V = new int[Vs.length];
        for (int i = 0; i < Vs.length; i++) {
            V[i] = Integer.valueOf(Vs[i]);
        }
        System.out.println(PowerPuke.maxPoint(P, V));
    }

    public static void main1(String[] args) {
        //   P = 10,V= [13]
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int[] V = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            V[i] = list.get(i);
        }
        System.out.println(PowerPuke.maxPoint(P, V));
    }

    private static int maxPoint(int P, int[] V) {
        Arrays.sort(V);
        int max = 0;
        int point = 0;
        int i = 0, j = V.length - 1;
        while (i < j) {
            while (P >= V[i]) {
                P -= V[i];
                point++;
                if (point > max) {
                    max = point;
                }
                i++;
            }
            if (point > 0) {
                P += V[j];
                point--;
                j--;
            }
        }
        return max;
    }
}
