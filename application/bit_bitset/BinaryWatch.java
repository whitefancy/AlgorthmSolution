package OJSolution.application.bit_bitset;

import java.util.*;

class BinaryWatch {
    public static void main(String[] args) {
        new BinaryWatch().readBinaryWatch(6);
    }

    /**
     * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
     * 8 4 2 1 32 16 8 4 2 1
     * 每个 LED 代表一个 0 或 1，最低位在右侧。
     * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
     * *bwftag  二进制 穷举 时分 状态ok
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        if (num > 10 || num < 0) {
            return null;
        }
        List<String> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 60; i++) {
            char[] chars = Integer.toBinaryString(i).toCharArray();
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    count++;
                }
            }
            List<Integer> list = map.getOrDefault(count, new LinkedList<>());
            list.add(i);
            map.put(count, list);
        }
        int n = Math.min(num, 4);
        for (int i = 0; i <= n; i++) {
            int m = num - i;
            if (m > 5) {
                continue;
            }
            List<Integer> hours = map.get(i);
            List<Integer> minutes = map.get(m);
            for (int hour : hours) {
                if (hour < 12) {
                    for (int minute : minutes) {
                        StringBuffer sb = new StringBuffer(hour + ":");
                        if (minute < 10) {
                            sb.append("0" + minute);
                        } else {
                            sb.append(minute);
                        }
                        ans.add(sb.toString());
                    }
                }
            }
        }
        return ans;
    }
}