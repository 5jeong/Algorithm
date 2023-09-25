package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 수열추측하기_DFS {

    static int[][] map = new int[10][10];
    static int[] num;
    static int[] temp;
    static int[] ch;
    static boolean flag=false;
    static int n,f;
    static int combi(int n,int r){
        if(map[n][r] > 0){
            return map[n][r];
        }
        if(n==r || r==0) return 1;
        else{
            return map[n][r] = combi(n-1,r-1) + combi(n-1,r);
        }
    }
    static void dfs(int L,int sum){
        if(flag==true){
            return;
        }
        if(L==n){
            if(sum==f){
                for(int x : num){
                    System.out.print(x+" ");
                }
                flag=true;
            }
        }
        else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    num[L] = i;
                    dfs(L+1,sum+(num[L] * temp[L]));
                    ch[i] = 0;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        num = new int[n];
        ch = new int[n+1];
        temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = combi(n-1,i);
        }
        dfs(0,0);
    }
}
