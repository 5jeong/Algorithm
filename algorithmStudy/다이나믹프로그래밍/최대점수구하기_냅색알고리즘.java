package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수구하기_냅색알고리즘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        int[] time = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[m+1];
        for(int i=0;i<n;i++){
            for(int j = m;j>=time[i];j--){
                dp[j] = Math.max(dp[j],dp[j-time[i]]+score[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
