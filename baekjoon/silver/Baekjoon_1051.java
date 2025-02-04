package baekjoon.silver;

import java.util.Scanner;

/***
 * 숫자 정사각형
 * N * M 크기의 직사각형중 꼭짓점에 쓰여있는 수가 모두 같은 가장 큰 정사각형 출력
 * 완탐 -> 슬라이딩 윈도우 -> 후보 찾기
 */
public class Baekjoon_1051 {
    static int n, m, ans;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int size = 1;
        int end = Math.min(n, m);
        board = new int[n][m];
        ans = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // 완탐
        while (size <= end) {
            game : for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    if (find(i, j, size)) {
                        ans = size;
                        break game;
                    }
                }
            }
            size++;
        }
        System.out.println(ans * ans);
    }

    static boolean find(int x, int y, int size) {
        int a = board[x][y];
        int b = board[x][y + size - 1];
        int c = board[x + size - 1][y];
        int d = board[x + size - 1][y + size - 1];
        return a == b && b == c && c == d;

    }
}
