package baekjoon.silver;

import java.util.Scanner;

/***
 * 체스판 다시칠하기
 * m * n 크기의 보드를 8*8 크리의 체스판으로 만듬
 * 체스판은 흰,검으로 번갈아 칠해져야함
 * 8*8 크기를 골라 다시 칠해야하는 최소 갯수 출력
 */
public class Baekjoon_1018 {
    static int n, m;
    static boolean[][] board;
    static int[] count;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
        count = new int[2]; // 0번째는 B, 1번째는 W
        ans = Integer.MAX_VALUE;
        // 완전 탐색
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                search(i, j);
            }
        }
        System.out.println(ans);
    }

    static void search(int x, int y) {
        int cnt = 0;
        boolean preColor = board[x][y]; // 이전 색상

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

                // 색이 다르면 갯수 증가
                if (preColor != board[i][j]) {
                    cnt++;
                }
                // 색 변경
                preColor = !preColor;
            }
            // 한줄이 넘어가면 색 변경
            preColor = !preColor;
        }
        ans = Math.min(ans,Math.min(cnt,64-cnt));
    }
}
