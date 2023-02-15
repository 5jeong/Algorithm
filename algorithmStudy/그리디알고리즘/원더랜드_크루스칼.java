package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 원더랜드_크루스칼 {
    static int[] unf;
    static class Edge implements Comparable<Edge>{
        int v1,v2,cost;
        Edge(int v1,int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost- o.cost;
        }
    }
    static int Find(int f){
        if(unf[f] == f){
            return f;
        }
        else{
            return unf[f] = Find(unf[f]);
        }
    }
    static void Union(int a,int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb){
            unf[fa] = unf[fb];
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Edge> arr = new ArrayList<>();
        unf = new int[v+1];
        for(int i=1;i<=v;i++){
            unf[i] = i;
        }
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c));
        }
        Collections.sort(arr);
        int ans = 0;
        for(Edge edge : arr){
            int v1 = Find(edge.v1);
            int v2 = Find(edge.v2);
            if(v1 != v2){
                ans+= edge.cost;
                Union(edge.v1,edge.v2);
            }
        }
        System.out.println(ans);

    }
}
