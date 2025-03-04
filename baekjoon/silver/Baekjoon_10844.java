package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 쉬운 계단 수
 */
public class Baekjoon_10844 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(9);
            return;
        }
        int ans = 0;
        int[][] dp = new int[n + 1][10]; // 길이가 n이고 마지막 숫자가 L일때 계단 총 수

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                switch (j) {
                    case 0 -> dp[i][j] = dp[i - 1][j + 1] % MOD;
                    case 9 -> dp[i][j] = dp[i - 1][j - 1] % MOD;
                    default -> dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % MOD;
                }
            }
        }
        for (int i = 0; i <= 9; i++) {
            ans = (ans + dp[n][i]) % 1_000_000_000;
        }
        System.out.println(ans);
    }
}
