package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1730 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.hasNext() ? sc.next() : "";
        char[][] board = new char[n][n];

        for (char[] x : board) {
            Arrays.fill(x, '.');
        }

        int x = 0;
        int y = 0;
        int nx = 0;
        int ny = 0;

        boolean[][] vertical = new boolean[n][n]; // 수직 여부
        boolean[][] horizontal = new boolean[n][n]; // 수평 여부

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == 'U') {
                nx = x - 1;
                ny = y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                vertical[x][y] = vertical[nx][ny] = true;
            } else if (now == 'D') {
                nx = x + 1;
                ny = y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                vertical[x][y] = vertical[nx][ny] = true;
            } else if (now == 'L') {
                nx = x;
                ny = y - 1;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                horizontal[x][y] = horizontal[nx][ny] = true;

            } else if (now == 'R') {
                nx = x;
                ny = y + 1;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                horizontal[x][y] = horizontal[nx][ny] = true;
            }
            x = nx;
            y = ny;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 수직 수평
                if (vertical[i][j] && horizontal[i][j]) {
                    board[i][j] = '+';
                }
                // 수직
                else if (vertical[i][j]) {
                    board[i][j] = '|';
                }
                // 수평
                else if (horizontal[i][j]) {
                    board[i][j] = '-';
                }
            }
        }

        for (char[] a : board) {
            for (char b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }

}
