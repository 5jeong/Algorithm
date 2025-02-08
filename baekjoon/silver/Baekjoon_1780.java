package baekjoon.silver;


import java.util.Scanner;

/***
 * 종이의 개수
 * N * N 크기의 종이가 -1,0,1중 하나가 저장
 *
 */
public class Baekjoon_1780 {
    static int n;
    static int[][] board;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        ans = new int[3];
        cut(0, 0, n);
        for (int x : ans) {
            System.out.println(x);
        }

    }

    // 9개씩 분할 정복
    static void cut(int x, int y, int n) {
        if (isPossible(x, y, n)) {
            int color = board[x][y] + 1;
            ans[color]++;
            return;
        }
        int size = n / 3;
        //분할
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cut(x + (i * size), y + (j * size), size);
            }
        }
//        dfs(x, y, size);
//        dfs(x, y + size, size);
//        dfs(x, y + size * 2, size);
//        dfs(x + size, y, size);
//        dfs(x + size, y + size, size);
//        dfs(x + size, y + size * 2, size);
//        dfs(x + size * 2, y, size);
//        dfs(x + size * 2, y + size, size);
//        dfs(x + size * 2, y + size * 2, size);
    }

    static boolean isPossible(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
