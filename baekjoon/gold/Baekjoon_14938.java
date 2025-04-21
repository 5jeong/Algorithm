package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 서강그라운드
public class Baekjoon_14938 {
    static int n, m, r;
    static List<List<Node>> graph;
    static int[] items, res, cost;

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
        n = sc.nextInt(); // 지역 개수
        m = sc.nextInt(); // 수색 범위
        r = sc.nextInt(); // 길의 개수
        res = new int[n + 1];
        items = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 아이템수 저장
        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cost, Integer.MAX_VALUE);
            dijkstra(i);
        }
        int ans=0;
        for(int x : res){
            ans = Math.max(ans,x);
        }

        System.out.println(ans);

    }

    // 다익스트라 + 수색범위 추가
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > cost[now.idx]) {
                continue;
            }

            for (Node next : graph.get(now.idx)) {
                if(cost[next.idx] > now.cost + next.cost && now.cost + next.cost <= m){
                    cost[next.idx] =   now.cost + next.cost;
                    pq.add(new Node(next.idx,cost[next.idx]));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(cost[i] != Integer.MAX_VALUE){
                res[start] += items[i];
            }
        }

    }
}
