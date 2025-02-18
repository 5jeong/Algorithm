package baekjoon.gold;

import java.util.Scanner;

/***
 * 가장 긴 바이토닉 부분 수열
 */
public class Baekjoon_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        int[] dp1 = new int[n]; // LIS
        int[] dp2 = new int[n]; // LDS

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 1. LIS (왼쪽에서 오른쪽)
        dp1[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // 1. LDS (오른쪽에서 왼쪽)
        dp2[n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        // 3. 가장 긴 바이토닉 부분 수열 길이 계산
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = dp1[i] + dp2[i];
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans - 1); // 중앙값은 겹치므로 -1
    }
}
