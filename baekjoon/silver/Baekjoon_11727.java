package baekjoon.silver;

import java.util.Scanner;

/**
 * 2xn 타일링2
 */
public class Baekjoon_11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n] );
    }
}
