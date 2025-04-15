package Promgrammers.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 섬연결하기_프림 {
    class Edge {
        int idx, cost;

        Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : costs) {
            int s = x[0];
            int e = x[1];
            int cost = x[2];
            graph.get(s).add(new Edge(e, cost));
            graph.get(e).add(new Edge(s, cost));
        }

        int[] ch = new int[n];

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (ch[now.idx] == 0) {
                ch[now.idx] = 1;
                answer += now.cost;
                for (Edge next : graph.get(now.idx)) {
                    if (ch[next.idx] == 0) {
                        pq.add(new Edge(next.idx, next.cost));
                    }
                }
            }
        }

        return answer;
    }
}
