package Algorithm.basicKnowledge.Algothrom.dynamic;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * <p>
 * 执行结果：
 * 通过
 */
public class MinCostForTickets {
    int n;
    int[] days;
    int[] dp;

    /**
     * 今天买多少，得看后几天怎么安排」，即「前面依赖后面」——从后向前来买。
     * dp[i] = min(决策1, 决策2, 决策3);
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null) {
            return 0;
        }
        n = days.length;
        this.days = days;
        dp = new int[n];
        dp[n - 1] = min(costs[0], costs[1], costs[2]);
        for (int i = n - 2; i > -1; i--) {
            dp[i] = min(ind(i, 0) + costs[0], ind(i, 6) + costs[1], ind(i, 29) + costs[2]);
        }
        return dp[0];
    }

    int min(int a, int b, int c) {
        int temp = a > b ? b : a;
        return temp > c ? c : temp;
    }

    int ind(int d, int k) {
        int m = days[d] + k;
        for (int i = d; i < days.length; i++) {
            if (m < days[i]) {
                return dp[i];
            }
        }
        return 0;
    }
}
