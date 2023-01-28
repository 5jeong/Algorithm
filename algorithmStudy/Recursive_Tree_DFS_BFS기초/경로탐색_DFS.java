package algorithmStudy.Recursive_Tree_DFS_BFS기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로탐색_DFS {
    static int[][] graph;
    static int[] check;
    static int n,m,ans=0;
    public static int DFS(int v){
        if(v == 5){
            ans++;
        }
        else{
            for(int i=1;i<=n;i++){
                if(graph[v][i] == 1 && check[i]==0){
                    check[v]=1;
                    DFS(i);
                    check[v]=0;
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
        graph = new int[n+1][n+1];
        check = new int[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        check[1]=1;
        System.out.println(DFS(1));
    }
}
