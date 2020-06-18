package OJSolution.feature.graph;

import java.util.*;

public class TopologicalSort {
    private List<ArrayList> G;
    private int[] visited;

    //这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
    public void test() {
        int n;
        int[][] edges;
        n = 4;
        //edges =new int[][]{{1,0}};
        edges = new int[][]{{3, 1}, {1, 0}, {2, 0}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(n, edges)));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        G = new ArrayList<>();
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            G.add(list);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            G.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!DFSTraverse(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean DFSTraverse(int v) {
        visited[v] = 1;
        for (int i = 0; i < G.get(v).size(); i++) {
            int w = (Integer) G.get(v).get(i);
            switch (visited[w]) {
                case 0:
                    if (!DFSTraverse(w)) {
                        return false;
                    }
                    break;
                case 1:
                    return false;
                case 2:
                    break;
            }
        }
        visited[v] = 2;
        return true;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        boolean[][] G = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int out = prerequisites[i][0];
            int in = prerequisites[i][1];
            indegree[in]++;
            G[out][in] = true;
        }
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.remove();
            count++;
            for (int w = 0; w < numCourses; w++) {
                if (G[v][w] == true) {
                    indegree[w]--;
                    if (indegree[v] == 0) {
                        queue.add(w);
                    }
                }
            }
        }
        // 这里不能用是否所有的节点入度都为空了来表示，为什么？
        if (count < numCourses) {
            return false;
        } else {
            return true;
        }
    }

    //现在你总共有 n 门课需要选，记为 0 到 n-1。
    //在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
    //给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
    //可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
    private int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        boolean[][] G = new boolean[numCourses][numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int out = prerequisites[i][1];
            int in = prerequisites[i][0];
            indegree[in]++;
            G[out][in] = true;
        }
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                stack.push(i);
            }
        }
        // 用stack而不用queue是避免输出的节点重复
        while (!stack.isEmpty()) {
            int v = stack.pop();
            order.add(v);
            for (int w = 0; w < numCourses; w++) {
                if (G[v][w] == true) {
                    indegree[w]--;
                    if (indegree[w] == 0) {
                        stack.add(w);
                    }
                }
            }
        }
        if (order.size() < numCourses) {
            order = new ArrayList<>();
        }
        return order.stream().mapToInt((Integer in) -> in).toArray();
    }
}
