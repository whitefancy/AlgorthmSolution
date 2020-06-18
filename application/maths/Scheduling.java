package OJSolution.application.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scheduling {
    private List<int[]> list;
    private int now = 0;
    private int count = 0;

    public int scheduleCourse(int[][] courses) {
        list = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            courses[i][1] -= courses[i][0];
            list.add(courses[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (Integer.compare(o1[0], o2[0]) != 0) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });
        int die = list.get(0)[1];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] < die) {
                die = list.get(i)[1];
            }
        }
        while (true) {
            while (list.get(0)[1] <= now && now + list.get(0)[0] <= die) {
                count++;
                now += list.get(0)[0];
                list.remove(0);
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (Integer.compare(o1[1], o2[1]) != 0) {
                        return Integer.compare(o1[1], o2[1]);
                    } else {
                        return Integer.compare(o1[0], o2[0]);
                    }
                }
            });
            int willdie = 0;
            for (int i = 1; i < list.size(); i++) {
                if (now + list.get(0)[0] <= list.get(i)[1]) {
                    break;
                }
                willdie++;
            }
            die = list.get(1)[1];
            if (willdie < 2) {
                count++;
                now += list.get(0)[0];
                list.remove(0);
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (Integer.compare(o1[0], o2[0]) != 0) {
                        return Integer.compare(o1[0], o2[0]);
                    } else {
                        return Integer.compare(o1[1], o2[1]);
                    }
                }
            });
        }
    }
}
