package Algorithm_Study_Inflearn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수도배관공사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] dp = new int[d+1];
        for(int i=0;i<p;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for(int j = d ;j>l;j--){
                if(dp[j-l]!=0){
                    dp[j] = Math.max(dp[j],Math.min(dp[j-l],c));
                }
            }
            dp[l] = Math.max(dp[l],c);
        }

        System.out.println(dp[d]);
    }
}
