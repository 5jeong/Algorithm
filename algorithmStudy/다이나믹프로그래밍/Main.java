package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] =0;
        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=m;j++){
                dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }
        System.out.println(dp[m]);
    }
}
