package Promgrammers.level3;

import java.util.ArrayList;
import java.util.List;

public class 섬연결하기_유니온앤파인드 {
    static int[] unf;

    class Edge {
        int start, end, cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        unf = new int[n];
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }
        List<Edge> edges = new ArrayList<>();
        for (int[] x : costs) {
            edges.add(new Edge(x[0], x[1], x[2]));
        }

        edges.sort((a, b) -> a.cost - b.cost);

        for (Edge x : edges) {
            if (find(x.start) != find(x.end)) {
                answer += x.cost;
                union(x.start, x.end);
            }
        }
        return answer;
    }

    private int find(int v) {
        if (unf[v] == v) {
            return unf[v];
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }
}
