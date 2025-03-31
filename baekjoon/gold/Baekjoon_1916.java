package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 최소 비용 구하기
public class Baekjoon_1916 {
    static class Edge {
        int idx;
        int cost;

        Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 버스 개수

        List<List<Edge>> graph = new ArrayList<>();
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Edge(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int nowIdx = now.idx;
            int nowCost = now.cost;
            if (nowCost > dis[nowIdx]) {
                continue;
            }
            for (Edge next : graph.get(nowIdx)) {
                if (dis[next.idx] > nowCost + next.cost) {
                    dis[next.idx] = nowCost + next.cost;
                    pq.offer(new Edge(next.idx, nowCost + next.cost));
                }
            }
        }
        System.out.println(dis[end]);

    }
}
