package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라알고리즘 {
    static class Edge implements Comparable<Edge>{
        int idx,cost;
        Edge(int idx,int cost){
            this.idx=idx;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] dis = new int[n+1];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Edge>());
        }
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(1,0));
        dis[1]=0;
        while(!pQ.isEmpty()){
            Edge temp = pQ.poll();
            int now = temp.idx;
            int nowCost = temp.cost;
            if(nowCost > dis[now]) continue;
            for(Edge e : graph.get(now)){
                if(dis[e.idx] > nowCost + e.cost){
                    dis[e.idx] = nowCost + e.cost;
                    pQ.add(new Edge(e.idx,nowCost+e.cost));
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(dis[i] != Integer.MAX_VALUE){
                System.out.println(i+" : "+dis[i]);
            }
            else{
                System.out.println(i+" : impossible");
            }
        }



    }
}
