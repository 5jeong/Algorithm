package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB거리
 */
public class Baekjoon_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            dp[i][1] = Integer.parseInt(st.nextToken()); // 초록
            dp[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]); // 이전 집 초록 or 파랑 선택
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]); // 이전 집 빨강 or 파랑 선택
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]); // 이전 집 빨강 or 초록 선택
        }
        int ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(ans);
    }
}
