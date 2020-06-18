package OJSolution.unsolve;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Intervals {
    private int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return intervals;
        }
        int[][] result = new int[intervals.length + 1][2];
        if (intervals.length == 0) {
            result[0] = newInterval;
            return result;
        }
        int k = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result[k++] = intervals[i];
            } else if (intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else if (intervals[i][0] > newInterval[1]) {
                result[k++] = newInterval;
                newInterval = intervals[i];
            }
        }
        result[k++] = newInterval;
        return Arrays.copyOfRange(result, 0, k);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return intervals;
        }
        int[][] temp = new int[intervals.length + 1][2];
        if (intervals.length == 0) {
            temp[0] = newInterval;
            return temp;
        }
        System.arraycopy(intervals, 0, temp, 0, intervals.length);
        temp[intervals.length] = newInterval;
        return merge(temp);
    }

    private int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int a, b;
        for (int i = 0; i < intervals.length; i++) {
            a = intervals[i][0];
            b = intervals[i][1];
            if (map.getOrDefault(a, b) <= b) {
                map.put(a, b);
            }
        }
        a = map.firstKey();
        b = map.get(a);
        int[][] ans = new int[100][2];
        int ind = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int c = entry.getKey();
            int d = entry.getValue();
            if (c > b) {
                ans[ind][0] = a;
                ans[ind][1] = b;
                ind++;
                a = c;
                b = d;
            } else if (b < d) {
                b = d;
            }
        }
        ans[ind][0] = a;
        ans[ind][1] = b;
        ind++;
        return Arrays.copyOfRange(ans, 0, ind);
    }

    public void test() {
        int[][] input = new int[][]{{4, 6}, {8, 10}, {15, 18}};
        int[] a = new int[]{11, 12};
        //System.out.println(Arrays.deepToString(merge(input)));
        System.out.println(Arrays.deepToString(insert(input, a)));
    }
}
