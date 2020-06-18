package OJSolution.application.string;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinVersion {
    public static void main(String[] args) {
        String[] A = {"3", "4.3.5.4", "2.10.3", "2.4"};
        System.out.println(new MinVersion().getMinVersion(A));
    }

    /**
     * 给定若干版本号，返回最小的版本
     * *bwftag  字符串解析 版本号 比较大小 状态ok
     *
     * @param list
     * @return
     */
    private String getMinVersion(String[] list) {
        // 在这里编写代码
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o1 = o1.replace(".", "#");
                o2 = o2.replace(".", "#");
                String[] strings1 = o1.split("#");
                String[] strings2 = o2.split("#");
                int n = Math.min(strings1.length, strings2.length);
                for (int i = 0; i < n; i++) {
                    if (!strings1[i].equals(strings2[i])) {
                        return Integer.valueOf(strings1[i]) - Integer.valueOf(strings2[i]);
                    }
                }
                return strings1.length - strings2.length;
            }
        };
        if (list.length == 0) {
            return "";
        }
        PriorityQueue<String> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < list.length; i++) {
            queue.offer(list[i]);
        }
        return queue.poll();
    }
}
