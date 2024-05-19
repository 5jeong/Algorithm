package baekjoon.gold;

import java.util.Scanner;

public class baekjoon_2073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int p = sc.nextInt();
        int[] dp = new int[d + 1];
        for (int i = 0; i < p; i++) {
            int l = sc.nextInt();
            int c = sc.nextInt();
            for (int j = d; j >= l; j--) {
                if (j == l) {
                    dp[j] = Math.max(dp[j], c);
                }
                if (dp[j - l] != 0) {
                    int temp = Math.min(c, dp[j - l]);
                    dp[j] = Math.max(dp[j], temp);
                }
            }
        }
        System.out.println(dp[d]);
    }
}
