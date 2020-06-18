package OJSolution.application.pictureAnalysis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Skyline {
    /**
     * 给定一个柱状图，输出天际线
     * *bwftag  一般特性 图片解析  动态规划 状态ok
     *
     * @param buildings
     * @return
     */
    private List<List<Integer>> getSkyline(int[][] buildings) {

        int n;
        List<List<Integer>> list = new LinkedList<>();
        n = buildings.length;
        if (n == 0) {
            return list;
        }
        List<int[]> Skyline = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] building = buildings[i];
            int[] line;
            int m = Skyline.size();
            if (m != 0 && building[2] == 0) {
                continue;
            }
            if (m == 0 || Skyline.get(m - 1)[1] < building[0]) {
                // 第一条线 或 不相交
                line = new int[3];
                line[0] = building[0];
                line[1] = building[1];
                line[2] = building[2];
                Skyline.add(line);
            } else {
                //最右边的line
                int[] cur = Skyline.get(m - 1);
                if (cur[0] > building[1]) {

                } else if (cur[2] == building[2] && cur[1] < building[1]) {//高度相等
                    cur[1] = building[1];
                } else if (cur[2] < building[2] && cur[1] < building[1])//相交不包含 上楼梯
                {
                    if (cur[0] >= building[0])//包围
                    {
                        cur[1] = building[1];
                        cur[2] = building[2];
                    } else {//交错
                        cur[1] = building[0];
                        line = new int[3];
                        line[0] = building[0];
                        line[1] = building[1];
                        line[2] = building[2];
                        Skyline.add(line);
                    }
                } else if (cur[2] < building[2] && cur[1] >= building[1])//包含上楼梯
                {
                    //完全一致
                    if (cur[0] == building[0] && cur[1] == building[1]) {
                        cur[2] = building[2];
                    } else if (cur[0] > building[0]) {//前半部分
                        int t = cur[1];
                        int t1 = cur[2];
                        cur[1] = building[1];
                        cur[2] = building[2];
                        line = new int[3];
                        line[0] = building[1];
                        line[1] = t;
                        line[2] = t1;
                        Skyline.add(line);
                    } else if (cur[0] < building[0] && cur[1] == building[1]) {// 后半部分
                        int t = cur[1];
                        cur[1] = building[0];
                        line = new int[3];
                        line[0] = building[0];
                        line[1] = t;
                        line[2] = building[2];
                        Skyline.add(line);
                    } else {// 中间
                        int t = cur[1];
                        cur[1] = building[0];
                        line = new int[3];
                        line[0] = building[0];
                        line[1] = building[1];
                        line[2] = building[2];
                        Skyline.add(line);
                        line = new int[3];
                        line[0] = building[1];
                        line[1] = t;
                        line[2] = cur[2];
                        Skyline.add(line);
                    }
                } else if (cur[2] > building[2] && cur[1] < building[1])//相交不包含 下楼梯
                {
                    line = new int[3];
                    line[0] = cur[1];
                    line[1] = building[1];
                    line[2] = building[2];
                    Skyline.add(line);
                } else if (cur[2] > building[2] && cur[1] < building[1])//相交不包含 下楼梯
                {
                } else if (cur[2] > building[2] && cur[1] >= building[1])//包含下楼梯
                {
                }
                //前面的line 只有包含关系
                for (int j = m - 2; j > 0; j--) {
                    if (Skyline.get(j)[1] > building[0]) {
                        cur = Skyline.get(j);
                        if (cur[2] < building[2])//包含上楼梯
                        {
                            //前半部分
                            if (cur[0] > building[0]) {//完全盖住
                                cur[2] = building[2];
                            } else if (cur[0] < building[0]) {// 后半部分
                                int t = cur[1];
                                cur[1] = building[0];
                                line = new int[3];
                                line[0] = building[0];
                                line[1] = t;
                                line[2] = building[2];
                                Skyline.add(j + 1, line);
                            } else {// 中间
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        //处理 Styline输出
        int p = -1;
        int q = -1;
        List<Integer> point;
        for (int i = 0; i < Skyline.size(); i++) {
            point = new ArrayList<>(2);
            if (Skyline.get(i)[0] != p) {
                if (q != -1 && Skyline.get(i)[0] != q && Skyline.get(i - 1)[2] != 0) {
                    point.add(q);
                    point.add(0);
                    list.add(point);
                    point = new ArrayList<>(2);
                }
                if (i == 0 || Skyline.get(i - 1)[2] != Skyline.get(i)[2]) {
                    point.add(Skyline.get(i)[0]);
                    point.add(Skyline.get(i)[2]);
                    list.add(point);
                }
                p = Skyline.get(i)[0];
                q = Skyline.get(i)[1];
            }
        }
        if (Skyline.get(Skyline.size() - 1)[2] != 0) {
            point = new ArrayList<>(2);
            point.add(q);
            point.add(0);
            list.add(point);
        }
        return list;
    }

    public void test() {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        //  System.out.println(getSkyline(buildings).toString());
        buildings = new int[][]{{6765, 184288, 53874}, {13769, 607194, 451649}, {43325, 568099, 982005}, {47356, 933141, 123943}, {59810, 561434, 119381}, {75382, 594625, 738524}, {111895, 617442, 587304}, {143767, 869128, 471633}, {195676, 285251, 107127}, {218793, 772827, 229219}, {316837, 802148, 899966}, {329669, 790525, 416754}, {364886, 882642, 535852}, {368825, 651379, 6209}, {382318, 992082, 300642}, {397203, 478094, 436894}, {436174, 442141, 612149}, {502967, 704582, 918199}, {503084, 561197, 625737}, {533311, 958802, 705998}, {565945, 674881, 149834}, {615397, 704261, 746064}, {624917, 909316, 831007}, {788731, 924868, 633726}, {791965, 912123, 438310}};
        //System.out.println(getSkyline(buildings).toString());
        // buildings = new int[][]{{1,2,0},{3,7,1},{4,5,0}}; //[[1, 0], [3, 1], [7, 0]] [[1,2,0],[3,7,1],[4,5,0]]
        //System.out.println(getSkyline(buildings).toString());
        // buildings = new int[][]{{1,2,2},{2,7,2}}; //[[1, 0], [3, 1], [7, 0]] [[1,2,0],[3,7,1],[4,5,0]]
        // buildings = new int[][]{{1,2,2},{1,2,4},{1,2,6}};//[[0,2,3],[2,5,3]]  [0,3],[5,0]
        //  buildings = new int[][]{{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},{70,90,72},{85,120,59}};
        System.out.println(getSkyline(buildings).toString());

    }
}
