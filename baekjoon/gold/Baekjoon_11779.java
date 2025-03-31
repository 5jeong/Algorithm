package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

// 최소 비용 구하기2
public class Baekjoon_11779 {
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
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        int[] path = new int[n + 1]; // 경로저장

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.cost > dist[now.idx]) {
                continue;
            }
            for (Edge next : graph.get(now.idx)) {
                if (dist[next.idx] > now.cost + next.cost) {
                    dist[next.idx] = now.cost + next.cost;
                    pq.add(new Edge(next.idx, dist[next.idx]));
                    path[next.idx] = now.idx;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(dist[end]).append("\n");

        int now = end;
        Stack<Integer> stack = new Stack<>();
        while (now != 0) {
            stack.push(now);
            now = path[now];
        }
        ans.append(stack.size()).append("\n");

        while (!stack.isEmpty()) {
            ans.append(stack.pop()).append(" ");
        }
        System.out.println(ans);
    }
}
