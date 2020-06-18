package OJSolution.application.maths;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {
    private List<Integer> primes = new ArrayList<>();

    private void setPrimes() {
        primes.add(2);
        primes.add(3);
        int k = 5;
        for (int i = 2; i < 10000; ) {
            boolean flag = false;
            for (int m : primes) {
                if (k % m == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                primes.add(k);
                i++;
            }
            k++;
            while (k % 6 != 1 && k % 6 != 5) {
                k++;
            }
        }
    }

    public void test() {
        setPrimes();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            printPrimes(s - 1, e);
        }
    }

    private void printPrimes(int start, int end) {
        List list = primes.subList(start, end);
        int k = (end - start) / 10;
        int i;
        for (i = 0; i < k; i++) {
            String s = list.subList(i * 10, (i + 1) * 10).toString();
            System.out.println(s.substring(1, s.length() - 1).replace(",", ""));
        }
        String s = list.subList(i * 10, list.size()).toString();
        System.out.println(s.substring(1, s.length() - 1).replace(",", ""));
    }

    public void performance() {
        long start = Calendar.getInstance().getTimeInMillis();
        setPrimes();
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("cost time(ms):" + (end - start));
    }
}
