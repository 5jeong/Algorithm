package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 파티
public class Baekjoon_1238 {
    static int n;

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
        int m = sc.nextInt();
        int x = sc.nextInt();
        List<List<Edge>> forwardGraph = new ArrayList<>();
        List<List<Edge>> backwardGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            forwardGraph.add(new ArrayList<>());
            backwardGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            forwardGraph.get(a).add(new Edge(b, c));
            backwardGraph.get(b).add(new Edge(a, c));
        }
        int ans = 0;
        int[] forwardCost = dijkstra(x, forwardGraph);
        int[] backwardCost = dijkstra(x, backwardGraph);
        for (int i = 1; i <= n; i++) {
            int temp = forwardCost[i] + backwardCost[i];
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }

    static int[] dijkstra(int start, List<List<Edge>> graph) {

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        cost[start] = 0;
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.cost > cost[now.idx]) {
                continue;
            }
            for (Edge next : graph.get(now.idx)) {
                if (cost[next.idx] > now.cost + next.cost) {
                    cost[next.idx] = now.cost + next.cost;
                    pq.add(new Edge(next.idx, cost[next.idx]));
                }
            }
        }
        return cost;
    }
}
