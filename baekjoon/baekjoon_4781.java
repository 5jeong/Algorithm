package baekjoon;

import java.util.Scanner;

public class baekjoon_4781 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            double m1 = sc.nextDouble();
            int m = (int) Math.round(m1 * 100);
            if (n == 0 && m == 0) {
                break;
            }
            int[] dp = new int[m + 1];
            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                double p1 = sc.nextDouble();
                int p = (int) Math.round(p1 * 100);
                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
            System.out.println(dp[m]);
        }
    }
}
