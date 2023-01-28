package algorithmStudy.Recursive_Tree_DFS_BFS기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로탐색_인접리스트 {
    static int[] check;
    static int n,m,ans=0;
    static ArrayList<ArrayList<Integer>> graph;
    public static int DFS(int v){
        if(v==n){
            ans++;
        }
        else{
            for(int nx : graph.get(v)){
                if(check[nx]==0){
                    check[nx] = 1;
                    DFS(nx);
                    check[nx] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        check[1]=1;
        System.out.println(DFS(1));
    }
}
