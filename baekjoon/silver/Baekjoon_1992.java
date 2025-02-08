package baekjoon.silver;

import java.util.Scanner;

/***
 * 쿼드트리
 * 분할정복
 */
public class Baekjoon_1992 {
    static int n;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        // 맨 처음 체크
        if (isPossible(n, 0, 0)) {
            System.out.println(board[0][0]);
            return;
        }
        sb.append("(");
        dfs(n, 0, 0);
        sb.append(")");
        System.out.println(sb);
    }

    static void dfs(int n, int x, int y) {


        int mid = n / 2;
        // 왼쪽 위
        if (!isPossible(mid, x, y)) {
            sb.append("(");
            dfs(mid, x, y);
            sb.append(")");
        } else {
            sb.append(board[x][y]);
        }
        // 오른쪽 위
        if (!isPossible(mid, x, y + mid)) {
            sb.append("(");
            dfs(mid, x, y + mid);
            sb.append(")");
        } else {
            sb.append(board[x][y + mid]);
        }
        // 왼쪽 아래
        if (!isPossible(mid, x + mid, y)) {
            sb.append("(");
            dfs(mid, x + mid, y);
            sb.append(")");
        } else {
            sb.append(board[x + mid][y]);
        }
        // 오른쪽 아래
        if (!isPossible(mid, x + mid, y + mid)) {
            sb.append("(");
            dfs(mid, x + mid, y + mid);
            sb.append(")");
        } else {
            sb.append(board[x + mid][y + mid]);
        }
    }

    // 분할 하는지 확인
    static boolean isPossible(int n, int x, int y) {
        int num = board[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                // 색이 다르면 분할해야함
                if (num != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
