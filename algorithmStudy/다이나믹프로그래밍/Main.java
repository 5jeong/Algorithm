package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        int[] time = new int[n];
        int[] dp = new int[t+1];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            for(int j=t;j>=time[i];j--){
                dp[j] = Math.max(dp[j],dp[j -  time[i]]+score[i]);
            }
        }
        System.out.println(dp[t]);
    }
}
