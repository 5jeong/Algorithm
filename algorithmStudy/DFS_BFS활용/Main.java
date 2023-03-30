package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n,f;

    static int[] arr,pm,check;
    static int[][] dy = new int[35][35];
    static boolean flag = false;

    static int combi(int n,int r){
        if(dy[n][r] != 0){
            return dy[n][r];
        }
        if(n == r || r==0){
            return 1;
        }
        else{
            return dy[n][r] = combi(n-1,r-1)+combi(n-1,r);
        }
    }

    static void DFS(int L,int sum) {
        if(flag==true){
            return;
        }
        if(L==n){
            if(sum == f){
                flag=true;
                for(int x : pm){
                    System.out.print(x+" ");
                }
            }
        }
        else{
            for(int i=1;i<=n;i++){
                if(check[i] == 0){
                    check[i] = 1;
                    pm[L] = i;
                    DFS(L + 1, sum + (arr[L] * pm[L]));
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[n];
        check = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i] = combi(n-1,i);
        }
        DFS(0,0);
    }
}