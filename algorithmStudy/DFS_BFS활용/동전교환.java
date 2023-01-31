package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전교환 {
    static int n,m,ans=Integer.MAX_VALUE;
    static int[] coin, arr;
    static int DFS(int L,int sum){
        if(ans < L){
            return 0;
        }
        if(sum>m){
            return 0;
        }
        if(sum==m){
            ans = Math.min(ans,L);
            return ans;
        }
        else{
            for(int i=n-1;i>=0;i--){
                DFS(L+1,sum + coin[i]);
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        coin = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        DFS(0,0);
        System.out.println(ans);
    }
}
