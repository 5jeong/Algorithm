package baekjoon.gold;

import java.util.Scanner;

//펠린드롬 만들기
public class Baekjoon_1695 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];

//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= n - i; j++) {
//                if (nums[j] == nums[i + j]) {
//                    dp[j][i + j] = dp[j + 1][i + j - 1];
//                } else {
//                    dp[j][i + j] = Math.min(dp[j][i + j - 1] + 1, dp[j + 1][i + j] + 1);
//                }
//            }
//        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (nums[i] == nums[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
