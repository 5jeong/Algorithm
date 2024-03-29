package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수구하기_DFS {
    static int n,m,ans=Integer.MIN_VALUE;
    static int[] score;
    static int[] time;

    static void DFS(int L,int score_sum,int time_sum){
        if(time_sum > m){
            return;
        }
        if(L==n){
            ans = Math.max(ans,score_sum);
        }
        else{
            DFS(L+1,score_sum+score[L],time_sum+time[L]);
            DFS(L+1,score_sum,time_sum);

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        score = new int[n];
        time = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0,0,0);
        System.out.println(ans);

    }
}
