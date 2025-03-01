package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 동전2
 */
public class Baekjoon_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        System.out.println(dp[k] == 100001 ? -1 : dp[k]);

    }
}
