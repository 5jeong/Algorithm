package baekjoon;

import java.util.Scanner;

public class baekjoon_1695 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (nums[j] == nums[i + j]) {
                    dp[j][i + j] = dp[j + 1][i + j - 1];
                } else {
                    dp[j][i + j] = Math.min(dp[j][i + j - 1] + 1, dp[j + 1][i + j] + 1);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
