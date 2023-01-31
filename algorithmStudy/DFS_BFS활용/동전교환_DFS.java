package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전교환_DFS {
    static int n,m,ans=Integer.MAX_VALUE;
    static Integer[] coin, arr;
    static void DFS(int L,int sum){
        if(ans < L){
            return ;
        }
        if(sum>m){
            return ;
        }
        if(sum==m){
            ans = Math.min(ans,L);
        }
        else{
            for(int i=0;i<n;i++){
                DFS(L+1,sum + coin[i]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        coin = new Integer[n];
        arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coin, Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        DFS(0,0);
        System.out.println(ans);
    }
}
