package OJSolution.application.time;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 有很多闹钟，
 * 知道上班时间和路上花的时间
 * 问最晚应该在哪个闹钟响起时起床
 * *bwftag  日期时间  状态ok
 */
public class Clock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<LocalTime> timeList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int hour = sc.nextInt();
                int min = sc.nextInt();
                LocalTime time = LocalTime.of(hour, min);
                timeList.add(time);
            }
            int way = sc.nextInt();
            int deadhour = sc.nextInt();
            int deadmin = sc.nextInt();
            LocalTime deadline = LocalTime.of(deadhour, deadmin);
            LocalTime lastline = deadline.plusMinutes(-way);
            Collections.sort(timeList);
            for (int i = timeList.size() - 1; i >= 0; i--) {
                if (!timeList.get(i).isAfter(lastline)) {
                    LocalTime time = timeList.get(i);
                    System.out.println(time.getHour() + " " + time.getMinute());
                    break;
                }
            }
        }
    }
}
