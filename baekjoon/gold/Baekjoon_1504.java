package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 특정한 최단 경로
public class Baekjoon_1504 {
    static int n, e;
    static List<List<Edge>> graph;
    static final int INF = 200_000_000; // 초기 최댓값

    static class Edge {
        int idx, cost;

        Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        // 반드시 방문해야될 지점
        int u = sc.nextInt();
        int v = sc.nextInt();
        int temp1 = dijkstra(1, u) + dijkstra(u, v) + dijkstra(v, n);
        int temp2 = dijkstra(1, v) + dijkstra(v, u) + dijkstra(u, n);
        int ans = Math.min(temp1, temp2);
        System.out.println(ans >= INF ? -1 : ans);

    }

    // 다익스트라
    static int dijkstra(int v1, int v2) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Edge(v1, 0));
        cost[v1] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.cost > cost[now.idx]) {
                continue;
            }
            for (Edge next : graph.get(now.idx)) {
                if (cost[next.idx] > now.cost + next.cost) {
                    cost[next.idx] = now.cost + next.cost;
                    pq.offer(new Edge(next.idx, cost[next.idx]));
                }
            }
        }

        return cost[v2];
    }
}
