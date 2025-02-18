package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 가장 긴 감소하는 부분 수열
 */
public class Baekjoon_11722 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[n]; // dp[i]는 nums[i]를 마지막 숫자인 감소 수열의 최대 길이
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    dp[i]  = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}