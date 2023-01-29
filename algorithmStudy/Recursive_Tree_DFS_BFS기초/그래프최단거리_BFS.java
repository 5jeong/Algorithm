package algorithmStudy.Recursive_Tree_DFS_BFS기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프최단거리_BFS {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dis;
    static int[] check;
    public static void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while(!q.isEmpty()){
            int cv = q.poll();
            for(int nv : graph.get(cv)){
                if(check[nv]==0){
                    q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                    check[nv] = 1;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = new int[n+1];
        check = new int[n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        check[1] = 1;
        BFS(1);
        for(int i=2;i<=n;i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
