package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 합분해
 */
public class Baekjoon_2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[k + 1][n + 1];

        // 초기값 설정
        Arrays.fill(dp[1], 1); // 1개의 숫자로 n을 만드는 방법은 1개
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1; // 0을 i개의 숫자로 만드는 방법은 1개
        }

        // dp 점화식
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1000000000; // 교환법칙 성립
            }
        }
        System.out.println(dp[k][n] );
    }
}
