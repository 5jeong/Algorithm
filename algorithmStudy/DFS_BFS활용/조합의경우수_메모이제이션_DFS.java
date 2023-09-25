package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합의경우수_메모이제이션_DFS {
    static int[][] map=new int[35][35];
    static int dfs(int n,int r){
        if(map[n][r] > 0) return map[n][r];
        if(n==r || r==0){
            return 1;
        }
        else{
            return map[n][r] = dfs(n-1,r-1) + dfs(n-1,r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int ans = dfs(n,r);
        System.out.println(ans);
    }
}
