package baekjoon.gold;

import java.util.Scanner;

/**
 * 동전1
 */
public class Baekjoon_2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        long[] dp = new long[k + 1];
        dp[0]=1; // 0원을 만드는법은 아무 동전도 사용하지않는 경우.
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
