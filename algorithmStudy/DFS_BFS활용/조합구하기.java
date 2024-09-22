package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 조합구하기 {
    static int[] combi;
    static int n,m;
    static void dfs(int L,int s){
        if(L==m){
            for(int x : combi){
                System.out.print(x+" ");
            }
            System.out.println();
        }else{
            for(int i=s;i<=n;i++){
                combi[L] = i;
                dfs(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        combi = new int[m];
        dfs(0,1);

    }
}
