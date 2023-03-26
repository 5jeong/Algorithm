package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n,r;
    static int[][] arr = new int[34][34];
    static int DFS(int n,int r) {
        if(arr[n][r] !=0){
            return arr[n][r];
        }
        if(r==0 || n==r){
            return 1;
        }
        else{
            arr[n][r] = DFS(n-1,r-1)+DFS(n-1,r);
            return arr[n][r];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int ans = DFS(n,r);
        System.out.println(ans);
    }
}