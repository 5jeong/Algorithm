package baekjoon.silver;

import java.util.Scanner;

public class Baekjoon_10971 {
    static int n;
    static int[][] board;
    static int[] ch;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ch = new int[n];
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, 0, 0);
        System.out.println(ans);
    }

    static void dfs(int L, int sum, int now, int start) {
        if (L == n && now == start) {
            ans = Math.min(ans, sum);
        } else {
            for (int i = 0; i < n; i++) {
                if (board[now][i] != 0 && ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L + 1, sum + board[now][i], i, start);
                    ch[i] = 0;
                }
            }
        }
    }
}
