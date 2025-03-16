package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사2
public class Baekjoon_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] time = new int[n + 2];
        int[] point = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            point[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n+1; i++) {
            dp[i] = Math.max(dp[i],dp[i-1]);
            int start = i + time[i];
            if (start > n + 1) {
                continue;
            }
            dp[start] = Math.max(dp[start], dp[i] + point[i]);
        }

        System.out.println(dp[n+1]);

    }
}
