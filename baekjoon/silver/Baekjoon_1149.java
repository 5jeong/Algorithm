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
        int[][] house = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            house[i][0] = red;
            house[i][1] = green;
            house[i][2] = blue;
        }

        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = house[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = house[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = house[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        int ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(ans);
    }
}
