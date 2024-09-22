package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 바둑이승차_DFS {

    static int[] arr;
    static int n, c,ans = Integer.MIN_VALUE;

    private static void dfs(int L, int sum, int[] arr) {
        if(sum > c){
            return;
        }
        if(L==n){
            ans = Math.max(ans,sum);
        }else{
            dfs(L+1,sum+arr[L],arr);
            dfs(L+1,sum,arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ans=0;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0,arr);
        System.out.println(ans);
    }
}