package baekjoon.silver;

import java.util.Scanner;

/***
 * N과 M(3)
 * 중복 수열
 */
public class Baekjoon_15651 {
    static int n, m;
    static int[] ch;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();
        ch = new int[n + 1];
        res = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int L) {
        if (L == m) {
            for (int x : res) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                res[L] = i;
                dfs(L + 1);
            }
        }
    }

}
