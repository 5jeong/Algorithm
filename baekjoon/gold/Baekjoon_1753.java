package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 최단경로
public class Baekjoon_1753 {
    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int start = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dis = new int[v + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Node(start, 0));
        dis[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > dis[now.idx]) {
                continue;
            }

            for (Node next : graph.get(now.idx)) {
                if (dis[next.idx] > now.cost + next.cost) {
                    dis[next.idx] = now.cost + next.cost;
                    pq.add(new Node(next.idx, dis[next.idx]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            System.out.println(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]);
        }

    }
}
