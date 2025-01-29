package baekjoon.silver;

import java.util.Scanner;

public class Baekjoon_1182 {
    static int n, s, ans;
    static int[] ch;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        ans = 0;
        nums = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(0, 0);
        System.out.println(s == 0 ? ans - 1 : ans);
    }

    static void dfs(int L, int sum) {
        if (L == n) {
            if (sum == s) {
                ans++;
            }
        } else {
            dfs(L + 1, sum + nums[L]);
            dfs(L + 1, sum);
        }
    }
}
