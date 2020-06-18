package OJSolution.application.graph;

import java.util.List;

/**
 * 周围很多居民楼
 * 找到一个空地
 * 建物流站，使得到所有居民楼距离最短
 * 求物流站的坐标
 * <p>
 * 梯度下降法
 */
public class TrasferStation {
    private int[][] graph;//因为距离和与地图共用一个图，所以居民楼标记为-1，商店所在位置使用正数
    private List<Node> nodes;
    private List<Node> avail;

    public static void main(String[] args) {

    }

    private long sumLength(int x, int y) {
        if (graph[x][y] > 0) {//如果已经计算过了，直接返回值
            return graph[x][y];
        }
        int sum = 0;
        for (int i = 0; i < nodes.size(); i++) {
            sum += (nodes.get(i).x - x) + (nodes.get(i).y - y);
        }
        graph[x][y] = sum;
        return sum;
    }

    long search() {
        //随机选一个点开始
        if (avail.size() == 0) {
            return -1;
        }
        Node start = avail.get(avail.size() / 2);
        return minSum(start);
    }

    private long minSum(Node start) {

        long central = sumLength(start.x, start.y);
        Node next = null;
        if (sumLength(start.x - 1, start.y - 1) < central) {
            next = new Node(start.x - 1, start.y - 1);
        }
        if (sumLength(start.x - 1, start.y) < central) {
            next = new Node(start.x - 1, start.y);
        }
        if (sumLength(start.x - 1, start.y + 1) < central) {
            next = new Node(start.x - 1, start.y);
        }
        if (sumLength(start.x + 1, start.y + 1) < central) {
            next = new Node(start.x + 1, start.y + 1);
        }
        if (sumLength(start.x + 1, start.y - 1) < central) {
            next = new Node(start.x - 1, start.y - 1);
        }
        if (sumLength(start.x + 1, start.y) < central) {
            next = new Node(start.x - 1, start.y);
        }
        if (null == next) {
            return central;
        } else {
            return minSum(next);
        }

    }

    class Node {
        public int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
