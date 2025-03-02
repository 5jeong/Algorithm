package baekjoon.gold;

import java.util.Scanner;

/**
 * 동전 바꿔주기
 */
public class Baekjoon_2624 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 목표 금액
        int k = sc.nextInt(); // 동전 종류수
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int amount = sc.nextInt(); // 동전 가치
            int cnt = sc.nextInt();    // 동전 개수

            for (int j = n; j >= 0; j--) { // 큰 금액부터 처리
                for (int s = 1; s <= cnt; s++) {
                    if (j + s * amount > n) { // 금액 초과 시 종료
                        break;
                    }
                    dp[j + s * amount] += dp[j];
                }
            }
        }

        System.out.println(dp[n]);
    }
}
