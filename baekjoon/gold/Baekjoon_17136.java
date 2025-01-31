package baekjoon.gold;

import java.util.Scanner;

/***
 * 색종이 붙이기
 * 1인경우 탐색
 * 1일때 색종이 5개 모두 붙여보기 (완탐 + dfs)
 *
 *
 */
public class Baekjoon_17136 {
    static int[][] board = new int[10][10];
    static int[] colorPaper = {0, 5, 5, 5, 5, 5};
    static int nx = 0;
    static int ny = 0;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 색종이 크기와 갯수 부여
        for (int i = 1; i <= 5; i++) {
            colorPaper[i] = 5;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    static void dfs(int x, int y, int cnt) {

        if (ans <= cnt) {
            return;
        }
        // baseCASE
        findNext(x, y);
        if (nx == -1 && ny == -1) {
            ans = Math.min(ans, cnt);
            return;
        }
        x = nx;
        y = ny;

        // 모든 사이즈 색종이 탐색
        for (int size = 1; size <= 5; size++) {

            if (colorPaper[size] <= 0) {
                continue;
            }
            if (isPossible(x, y, size)) {
                colorPaper[size]--;
                attach(x, y, size, 0); // 색종이 붙이기
                dfs(x, y, cnt + 1);
                attach(x, y, size, 1); // 원상복구
                colorPaper[size]++;
            }
        }

    }

    //색종이 붙일수 있는 후보 찾기 (완탐)
    static void findNext(int x, int y) {
        for (int i = x; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    nx = i;
                    ny = j;
                    return;
                }
            }
        }
        nx = -1;
        ny = -1;
    }

    // size크기의 색종이를 붙일수 있는지 확인
    static boolean isPossible(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) {
            return false;
        }
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // size만큼 색종이 붙이기
    static void attach(int x, int y, int size, int color) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = color;
            }
        }
    }
}
