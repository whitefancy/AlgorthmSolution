package OJSolution.feature.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。
 * 图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 * 给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * bwftag 二叉树 无向图 一般特性 状态未知
 */
public class MinHightTree {

    public void test() {
        int n;
        int[][] edges;
        n = 4;
        edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        //edges =new int[][]{{0,3},{3,2},{1,3},{4,3},{5,4}};
        System.out.println(findMinHeightTrees(n, edges).toString());
    }

    /**
     * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     *
     * @param n
     * @param edges
     * @return
     */
    private List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] nodelist = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            nodelist[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            nodelist[edges[i][0]].add(edges[i][1]);
            nodelist[edges[i][1]].add(edges[i][0]);
            //因为叶子节点只有一个邻居，所以异或仍能保留这个原始值
            //任何数与0异或都为其本身
            //两个相同数字异或等于零
            //            connected[v1] ^= v2;//通过异或存储所有与之相邻的节点
            //            connected[v2] ^= v1;
            //            degree[v1]++;// 该节点的度+1
            //            degree[v2]++;
            //                int v1 = connected[v];
            //                connected[v1] ^= v;
            //                degree[v1]--;
        }
        List<Integer> list = new ArrayList<>();
        int k = n;
        boolean[] visited = new boolean[n];
        while (k > 0) {
            list = new ArrayList<>();
            if (k == 1 || k == 2) {
                for (int i = 0; i < n; i++) {
                    if (visited[i] == false) {
                        list.add(i);
                    }
                }
                return list;
            }
            for (int i = 0; i < n; i++) {
                if (nodelist[i].size() == 1) {
                    list.add(i);
                }
            }
            for (int ii = 0; ii < list.size(); ii++) {
                int i = list.get(ii);
                int p = nodelist[i].get(0);
                for (int j = 0; j < nodelist[p].size(); ) {
                    //当我们将List的泛型参数设置为Integer时，我们只能使用前一种方式删除元素，
                    // 也即是按结点位置的方法删除元素。
                    // 因为无论传入的参数是int 类型还是Integer类型，都只会调用remove(int index)方法，
                    // 而不会调用remove(Object o)方法。
                    if (nodelist[p].get(j) == i) {
                        nodelist[p].remove(j);
                        break;
                    } else {
                        j++;
                    }
                }
                nodelist[i].remove(0);
                k--;
                visited[i] = true;
            }
        }
        return list;
    }
}
