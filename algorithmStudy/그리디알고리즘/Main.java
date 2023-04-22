package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;

        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ch = new int[v + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        int ans = 0;
        while (!pq.isEmpty()) {
            Edge temp = pq.poll();
            if (ch[temp.vex] == 0) {
                ch[temp.vex] = 1;
                for (Edge edge : graph.get(temp.vex)) {
                    pq.add(new Edge(edge.vex, edge.cost));
                }
                ans += temp.cost;
            }
        }
        System.out.println(ans);
    }
}
