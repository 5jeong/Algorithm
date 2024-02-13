package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_1994 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int k = nums[j] - nums[i];
                dp[i][j] = 2;
                for (int s = i - 1; s > 0; s--) {
                    if (nums[i] - k == nums[s]) {
                        dp[i][j] = dp[s][i] + 1;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
