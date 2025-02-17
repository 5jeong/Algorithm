package baekjoon.silver;

import java.util.Scanner;

/***
 * 피보나치 함수
 */
public class Baekjoon_1003 {
    static int[][] dp = new int[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // 1. DP 초기값 설정
        dp[0][0] = 1; // fibonacci(0)
        dp[1][1] = 1; // fibonacci(1)

        while (t-- > 0) {
            int n = sc.nextInt();

            // 재귀 + 메모이제이션(DP) 활용
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    static int[] fibonacci(int n) {
        if(dp[n][0] > 0 || dp[n][1] > 0){
            return dp[n];
        }
        dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
        dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];

        return dp[n];
    }
}
