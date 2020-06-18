package Algorithm.basicKnowledge.dataStructure.Array;

public class JumpGameII {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            // 如果长度为小于1，直接到达
            return 0;
        }

        // 每一次起跳的起点
        int index = 0;
        // 每一次起跳的终点
        int max = nums[0];
        // 跳到终点的最小步数，至少有一步
        int step = 1;

        while (max < len - 1) {
            // 循环获取 index->max 区间每个点可以到达的最远位置，其中最大的那个点就可以作为下一次的起点
            int curMax = 0;
            for (int i = index + 1; i <= max; i++) {
                if (i + nums[i] > curMax) {
                    // 当前点可以到达的最远距离更长
                    curMax = i + nums[i];
                    index = i;
                }
            }
            // 从当前起点可以到达的终点位置
            max = index + nums[index];
            //步数加一
            step++;
        }
        return step;
    }

    public int jump1(int[] nums) {
        int step = 0;
        int ind = 0;
        int max = 0;
        int end = nums.length - 1;
        if (end < 1) {
            return 0;
        }
        max = ind + nums[ind];
        step++;
        while (max < end) {
            //注意这里要用临时最大值比较，而不是全局最大值，因为max被用来做索引，不能随意增长
            int curMax = 0;
            for (int i = ind + 1; i <= max; i++) {
                if (nums[i] + i > curMax) {
                    ind = i;
                    curMax = ind + nums[ind];
                }
            }
            max = curMax;
            step++;
        }
        return step;

    }
}
