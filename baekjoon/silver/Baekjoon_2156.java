package baekjoon.silver;

import java.util.Scanner;

/**
 * 포도주 시식
 */
public class Baekjoon_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        /***
         * dp[0][n] : n번째 잔을 선택하지 않은 경우
         * dp[1][n] : n-1잔을 선택하지 않고 n번째 잔을 선택한 경우
         * dp[2][n] ; n-1잔, n잔 모두 선택한 경우
         */
        int[] dp = new int[10001];

        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }
        System.out.println(dp[n]);

    }
}
