package OJSolution.feature.string;

import java.util.Scanner;

public class PATCount {
    /**
     * 这道题的关键是将PAT分为三个类
     * 从前往后  统计P的数量
     * 每一个A对应所有的P  那么每次遇到一个A PA的数量就加上P的数量
     * 每一个T对应所有的PA  那么每一个T  就加PA
     * *bwftag  一般特性 字符串匹配 动态规划 状态ok
     *
     * @param s
     * @return
     */
    private int summary(String s) {
        int sumP = 0, sumA = 0, sumT = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'P':
                    sumP++;
                    break;
                case 'A':
                    sumA = (sumA + sumP) % 1000000007;
                    break;
                case 'T':
                    sumT = (sumT + sumA) % 1000000007;
            }
        }
        return sumT;
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(summary(s));
        }
    }
}
