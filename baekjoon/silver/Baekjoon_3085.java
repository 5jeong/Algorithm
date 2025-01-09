package baekjoon.silver;

import java.io.IOException;
import java.util.Scanner;

/***
 * 완전탐색
 * 원본 최대값 구하기
 * 서로 다른 색의 두칸의 모든 경우의 수를 탐색해서 바꿈
 * 바꾼결과에서 최대값 구하기
 */
public class Baekjoon_3085 {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static char[][] board;
    static int n, max;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 증가하는 방향만 보면된다. (오른쪽 방향, 아래방향)
                for (int dir = 0; dir < 2; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    // 서로 색이 다를때 교환
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != board[i][j]) {
                        swap(i, j, nx, ny);
                        max = Math.max(max, getMax());
                        // 원상복구
                        swap(i, j, nx, ny);
                    }
                }
            }
        }
        System.out.println(max);

    }

    // 가장 긴 행, 열 구하기
    private static int getMax() {
        // 가장 긴 행(가로)
        int maxRow = 1;
        for (int i = 0; i < n; i++) {
            int tempRow = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    tempRow++;
                } else {
                    maxRow = Math.max(maxRow, tempRow);
                    tempRow = 1;
                }
            }
            maxRow = Math.max(maxRow, tempRow);
        }

        int maxCol = 1;
        // 가장 긴 열(세로)
        for (int i = 0; i < n; i++) {
            int tempCol = 1;
            for (int j = 1; j < n; j++) {
                if (board[j][i] == board[j - 1][i]) {
                    tempCol++;
                } else {
                    maxCol = Math.max(maxCol, tempCol);
                    tempCol = 1;
                }
            }
            maxCol = Math.max(maxCol, tempCol);
        }
        return Math.max(maxCol, maxRow);

    }

    // 교환
    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
