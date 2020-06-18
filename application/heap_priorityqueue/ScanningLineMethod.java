package OJSolution.application.heap_priorityqueue;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 扫描线法
 */
public class ScanningLineMethod {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] b1 = new int[10000][3];
        Scanner in = new Scanner(new File("test/test.txt"));
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 3; j++) {
                b1[i][j] = in.nextInt();
            }
        }
        new ScanningLineMethod().getSkyline(b1);
        b1 = new int[][]{{0, 17, 13}, {2, 5, 11}, {2, 6, 10}, {2, 7, 9}};
        new ScanningLineMethod().getSkyline(b1);
        b1 = new int[][]{{0, 2, 3}, {2, 5, 3}};
        new ScanningLineMethod().getSkyline(b1);
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        new ScanningLineMethod().getSkyline(buildings);
        b1 = new int[][]{};
        new ScanningLineMethod().getSkyline(b1);
        b1 = new int[][]{{1, 2, 0}};
        new ScanningLineMethod().getSkyline(b1);
    }

    /**
     * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
     * 现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，
     * 请编写一个程序以输出由这些建筑物形成的天际线（图B）。
     * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”
     * （图B中的红点）的列表，它们唯一地定义了天际线。
     * 关键点是水平线段的左端点。
     * 请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。
     * 此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
     *
     * @param buildings
     * @return
     */
    private List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        Comparator<Pair<Integer, Integer>> order = new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() < o2.getKey()) {
                    return -1;
                } else if (o1.getKey() == o2.getKey()) {
                    if (o1.getValue() > o2.getValue()) {
                        return -1;
                    } else if (o1.getValue() == o2.getValue()) {
                        return 1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        };
        if (buildings.length == 0) {
            return ans;
        }
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(buildings.length * 2, order);
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < buildings.length; i++) {
            int[] bu = buildings[i];
            queue.offer(new Pair<>(bu[0], bu[2]));
            queue.offer(new Pair<>(bu[1], -bu[2]));
        }
        int now = -1;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int h = pair.getValue();
            int p = pair.getKey();
            if (h >= 0) {
                queue1.offer(h);
                if (queue1.peek() != now) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(p);
                    list.add(queue1.peek());
                    ans.add(list);
                    now = queue1.peek();
                }
            } else {
                queue1.remove(-h);
                if (queue1.isEmpty() || queue1.peek() != now) {
                    if (queue1.isEmpty()) {
                        List<Integer> list = new ArrayList<>(2);
                        list.add(p);
                        list.add(0);
                        ans.add(list);
                        now = 0;
                    } else {
                        List<Integer> list = new ArrayList<>(2);
                        list.add(p);
                        list.add(queue1.peek());
                        ans.add(list);
                        now = queue1.peek();
                    }
                }
            }
        }
        List<List<Integer>> filt = new ArrayList<>(ans.size());
        for (int i = 0; i < ans.size() - 1; i++) {
            if (!ans.get(i).get(0).equals(ans.get(i + 1).get(0))) {
                filt.add(ans.get(i));
            }
        }
        filt.add(ans.get(ans.size() - 1));
        return filt;
    }
}
