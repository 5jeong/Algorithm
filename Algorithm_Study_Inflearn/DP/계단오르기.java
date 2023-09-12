package Algorithm_Study_Inflearn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        int[] score = new int[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = score[1];
        dp[2] = dp[1] + score[2];
        for(int i=3;i<=n;i++){
            int a = dp[i-2] + score[i];
            int b = dp[i-3] + score[i-1]+ score[i];
            dp[i] = Math.max(a,b);
        }
        System.out.println(dp[n]);

    }
}
