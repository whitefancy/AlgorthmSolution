package OJSolution.application.maths;

/**
 * 掷骰子的N种方法  显示英文描述  我的提交返回竞赛
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况
 * （所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回
 */
class Rolls {
    private long probality[][];

    int numRollsToTarget(int d, int f, int target) {
        if (target > d * f) {
            return 0;
        }
        if (target < d) {
            return 0;
        }
        probality = new long[d][d * f + 1];
        for (int i = 1; i <= f; i++) {
            probality[0][i] = 1;
        }
        //色子编号 0,1,2,...,d-1
        //数字大小 1,2,3，..,f
        for (int k = 1; k < d; k++) {//第k个色子开始丢
            for (int j = 1; j <= k * f; j++) {//第k号色子丢完，总点数为j的次数
                long now = probality[k - 1][j];
                for (int i = 1; i <= f; i++) {//第k号色子丢出的数字
                    probality[k][i + j] = (probality[k][i + j] + now) % (1000000000 + 7);
                }
            }
        }
        return (int) probality[d - 1][target];
    }

}
