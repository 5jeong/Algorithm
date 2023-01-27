package algorithmStudy.Recursive_Tree_DFS_BFE기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수열_재귀 {
    static int[] fibo;
    public static int DFS(int n){
        if(fibo[n] > 0){
            return fibo[n];
        }
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n]=1;
        else{
            return fibo[n] = DFS(n-2)+DFS(n-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n+1];
        DFS(n);
        for(int i=1;i<=n;i++){
            System.out.print(fibo[i]+" ");
        }
    }
}
