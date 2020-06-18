package OJSolution.application.maths;

import java.util.Scanner;

public class RunningTime {
    //    得一个函数f的运行时间，我们只要在调用f之前先调用clock()，获得一个时钟打点数C1；在f执行完成后再调用clock()，获得另一个时钟打点
//    数C2；两次获得的时钟打点数之差(C2-C1)就是f运行所消耗的时钟打点数，再除以常数CLK_TCK，就得到了以秒为单位的运行时间。
//
//    这里不妨简单假设常数CLK_TCK为100。现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。
    private String CaculateTime(long n1, long n2) {
        String time = "";
        long during = n2 - n1;
        long hh = during / 360000;
        during = during % 360000;
        long mm = during / 6000;
        during = during % 6000;
        long ss = during / 100;
        if (during % 1000 >= 500) {
            ss += 1;
        }

        return "" + String.format("%02d", hh) + ":" + String.format("%02d", mm) + ":" + String.format("%02d", ss);
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(CaculateTime(n, m));
        }
    }
}
