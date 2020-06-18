package OJSolution.uncategorized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PayWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Work> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            Work work = new Work(a, b);
            list.add(new Work(a, b));
        }
        Collections.sort(list);
        for (int i = 0; i < M; i++) {
            long person = sc.nextLong();
            boolean get = false;
            for (int j = 0; j < N; j++) {
                if (person >= list.get(j).need) {
                    System.out.println(list.get(j).pay);
                    get = true;
                    break;
                }
            }
            if (!get) {
                System.out.println(0);
            }
        }
    }

    static class Work implements Comparable<Work> {
        long need;
        long pay;

        Work(long n, long p) {
            need = n;
            pay = p;
        }

        @Override
        public int compareTo(Work o) {
            if (pay > o.pay) {
                return -1;
            } else if (pay == o.pay) {
                return 0;
            } else {
                return 1;
            }
        }
    }

}
