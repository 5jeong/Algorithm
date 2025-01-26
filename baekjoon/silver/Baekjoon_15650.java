package baekjoon.silver;

import java.util.Scanner;

/***
 * N과 M(2)
 * 중복 없는 수열
 * 고른 수열이 오름차순일때만 출력
 */
public class Baekjoon_15650 {
    static int n, m;
    static int[] ch;
    static int[] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        res = new int[m];
        dfs(1, 0);
    }

    private static void dfs(int s, int L) {
        if (L == m) {
            for (int x : res) {
                System.out.print(x + " ");
            }
            System.out.println();

        } else {
            for (int i = s; i <= n; i++) {
                res[L] = i;
                dfs(i + 1, L + 1);
            }
        }
    }

}
