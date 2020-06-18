package OJSolution.application.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个树，给出任意两点的距离表
 * 然后给出 所有两点距离按照模3分类的和
 * select count(length) from graph group by length%3;
 * *bwftag  图遍历 无向图 状态未知
 */
public class Runways {
    private int[][] graph;
    private List<Integer>[] lgraph;

    private Runways(int[][] graph, List<Integer>[] lgraph) {
        this.graph = graph;
        this.lgraph = lgraph;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();

            int[][] graph = new int[n + 1][n + 1];
            List<Integer>[] lgraph = new List[n + 1];
            for (int i = 0; i <= n; i++) {
                List<Integer> list = new LinkedList<>();
                lgraph[i] = list;
            }
            for (int i = 1; i < n; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u][0] = v;
                graph[v][0] = u;
                graph[0][u] = v;
                graph[0][v] = u;
                graph[u][v] = 1;
                graph[v][u] = 1;
                lgraph[u].add(v);
                lgraph[v].add(u);
            }
            Runways so = new Runways(graph, lgraph);
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (graph[i][j] == 0) {
                        List<Integer> route = new LinkedList<>();
                        route.add(i);
                        so.reverse(route);
                    }
                }

            }
            long c0 = 0, c1 = 0, c2 = 0;
            long K = 1000000000 + 7;
            for (int i = 1; i < graph.length; i++) {
                for (int j = i + 1; j <= n; j++) {
                    switch (graph[i][j] % 3) {
                        case 0:
                            c0 = (c0 + graph[i][j]) % K;
                            break;
                        case 1:
                            c1 = (c1 + graph[i][j]) % K;
                            break;
                        case 2:
                            c2 = (c2 + graph[i][j]) % K;
                            break;
                    }
                }
            }
            System.out.println(c0 + " " + c1 + " " + c2);
        }
    }

    private void reverse(List<Integer> route) {
        int root = route.get(route.size() - 1);
        for (int i = 0; i < lgraph[root].size(); i++) {
            int arrive = lgraph[root].get(i);
            if (route.indexOf(arrive) == -1) {
                for (int j = 0; j < route.size() - 1; j++) {
                    if (graph[route.get(j)][arrive] == 0) {
                        graph[route.get(j)][arrive] = route.size() - j;
                        graph[arrive][route.get(j)] = route.size() - j;

                    }
                }
                route.add(arrive);
                reverse(route);
            }
        }
        route.remove(route.size() - 1);
    }
}
