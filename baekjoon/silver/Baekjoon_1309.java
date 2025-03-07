package baekjoon.silver;

import java.util.Scanner;

/**
 * 동물원
 */
public class Baekjoon_1309 {

    static final int NONE = 0;
    static final int LEFT = 1;
    static final int RIGHT = 2;
    public static final int MOD = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n + 1][3]; // n배열에 사자를 왼쪽, 오른쪽, 비어둘지 3개의 경우

        dp[1][NONE] = 1;
        dp[1][LEFT] = 1;
        dp[1][RIGHT] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][NONE] = (dp[i - 1][LEFT] + dp[i - 1][RIGHT] + dp[i - 1][NONE]) % MOD;
            dp[i][LEFT] = (dp[i - 1][RIGHT] + dp[i - 1][NONE]) % MOD;
            dp[i][RIGHT] = (dp[i - 1][LEFT] + dp[i - 1][NONE]) % MOD;
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += dp[n][i] % MOD;
        }
        System.out.println(ans);

    }
}
