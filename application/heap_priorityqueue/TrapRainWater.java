package OJSolution.application.heap_priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，
 * 请计算图中形状最多能接多少体积的雨水。
 */
public class TrapRainWater {
    PriorityQueue<Wall> queue;
    private boolean[][] isVisited;
    private int[][] heightMap;

    public int trapRainWater(int[][] heightMap) {
        this.heightMap = heightMap;
        Comparator<Wall> order = new Comparator<Wall>() {
            @Override
            public int compare(Wall o1, Wall o2) {
                return heightMap[o1.x][o1.y] - heightMap[o2.x][o2.y];
            }
        };
        queue = new PriorityQueue<>(order);
        isVisited = new boolean[heightMap.length][heightMap[0].length];
        return 0;
    }

    void reduceHight(int h) {
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                if (heightMap[i][j] > h) {
                    heightMap[i][j] -= h;
                } else {
                    heightMap[i][j] = 0;
                }
            }
        }
    }

    void pushLine(int x, int y) {
        addWall(x + 1, y);
        addWall(x - 1, y);
        addWall(x, y + 1);
        addWall(x, y - 1);
    }

    private void addWall(int x, int y) {
        if (!isVisited[x][y]) {
            queue.offer(new Wall(x, y));
            isVisited[x][y] = true;
        }
    }
}

class Wall {
    int x;
    int y;

    Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
