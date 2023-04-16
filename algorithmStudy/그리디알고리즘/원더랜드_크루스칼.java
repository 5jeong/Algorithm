package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 원더랜드_크루스칼 {
    static int[] unf;

    static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int Find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        unf = new int[v + 1];
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(v1, v2, cost));
        }
        int ans = 0;
        Collections.sort(edges);
        for (Edge x : edges) {
            if (Find(x.v1) != Find(x.v2)) {
                ans += x.cost;
                Union(x.v1, x.v2);
            }
        }
        System.out.println(ans);
    }
}
