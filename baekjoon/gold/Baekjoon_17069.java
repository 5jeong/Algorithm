package baekjoon.gold;

import java.util.Scanner;

//파이프 옮기기2
public class Baekjoon_17069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n + 1][n + 1];
        long[][][] dp = new long[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // 시작지점
        dp[1][2][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (board[i][j] == 1) {
                    continue;
                }

                // 가로 도착
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                // 세로 도착
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                // 대각선 도착, 주변 다 비워있어야함
                if (board[i][j - 1] == 1 || board[i - 1][j] == 1) {
                    continue;
                }
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];

            }
        }
        long ans = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(ans);
    }
}
