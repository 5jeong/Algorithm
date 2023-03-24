package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int c,n;
    static int ans = Integer.MIN_VALUE;
    static int[] arr;
    static void DFS(int L,int sum){
        if(sum>c){
            return;
        }
        if(L==n){
            if(ans < sum){
                ans = sum;
            }
        }
        else{
            DFS(L+1,sum+arr[L]);
            DFS(L+1,sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0,0);
        System.out.println(ans);
    }
}