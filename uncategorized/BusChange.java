package OJSolution.uncategorized;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BusChange {
    public void test() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int placeN = sc.nextInt();
            int busN = sc.nextInt();
            Bus[][] places = new Bus[placeN][placeN];
            for (int i = 0; i < busN; i++) {
                Bus bus = new Bus();
                bus.id = sc.nextInt();
                int start = sc.nextInt();
                int end = sc.nextInt();
                bus.cost = sc.nextInt();
                if (places[start][end] == null || places[start][end].cost > bus.cost) {
                    places[start][end] = bus;
                    places[end][start] = bus;
                }
            }
            int now = sc.nextInt();
            int arm = sc.nextInt();
            int minCost = 0;
            Queue<Status> queue = new ArrayDeque<>();
            for (int i = 0; i < places.length; i++) {
                if (places[now][i] != null) {
                    if (i == arm) {
                        minCost = places[now][i].cost;
                    } else {
                        Status status = new Status();
                        status.station = i;
                        status.cost = places[now][i].cost;
                        queue.add(status);
                    }
                }
            }
            while (!queue.isEmpty()) {
                Status cur = queue.poll();
                for (int i = 0; i < places.length; i++) {
                    if (places[cur.station][i] != null) {
                        if (i == arm && minCost > places[cur.station][i].cost) {
                            minCost = places[cur.station][i].cost;
                        } else {
                            Status status = new Status();
                            status.station = i;
                            status.cost += places[cur.station][i].cost;
                            queue.add(status);
                        }
                    }
                }
            }

        }
    }

    class Bus {
        int id;
        int cost;
    }

    class Status {
        int station;
        int cost;
    }
}
