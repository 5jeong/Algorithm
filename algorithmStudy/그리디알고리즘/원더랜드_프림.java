package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 원더랜드_프림 {
    static int[] ch;
    static class Edge implements Comparable<Edge>{
        int v;
        int cost;
            Edge(int v,int cost) {
            this.v = v;
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
        ch = new int[v+1];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(1,0));
        int ans=0;
        while(!pQ.isEmpty()){
            Edge temp = pQ.poll();
            if(ch[temp.v]==0){
                for(Edge edge : graph.get(temp.v)){
                    if(ch[edge.v]!=1){
                        pQ.add(edge);
                    }
                }
                ch[temp.v]=1;
                ans+=temp.cost;
            }
        }
        System.out.println(ans);
    }
}
