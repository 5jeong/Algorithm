package baekjoon;

import java.util.Scanner;

public class bakejoon_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }
        dp[1] = stairs[1];
        dp[2] = dp[1] + stairs[2];
        for (int i = 3; i <= n; i++) {
            int a = dp[i - 2] + stairs[i];
            int b = dp[i - 3] + stairs[i - 1] + stairs[i];
            dp[i] = Math.max(a, b);
        }
        System.out.println(dp[n]);
    }
}
