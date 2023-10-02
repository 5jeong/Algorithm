package swea;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 햄버거다이어트 {
    static int n,l,ans;
    static int[] score,cal;
    static int[] ch;

    static void dfs(int L,int s,int sum){
        if(sum < l){
            ans = Math.max(ans,s);
        }
        if(sum > l){
            return;
        }
        if(L==n){
            return;
        }
        else{
            dfs(L + 1, s + score[L], sum + cal[L]);
            dfs(L + 1, s, sum);
        }
    }
    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            l = sc.nextInt();
            ans=0;
            score = new int[n];
            cal = new int[n];
            ch = new int[n];
            for(int i=0;i<n;i++){
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            dfs(0,0,0);
            System.out.println("#"+test_case+" "+ ans);
        }
    }
}
