package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//치즈
public class Baekjoon_2638 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int n, m;
    static boolean[][] outAir; // 외부공기판단

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int time = 0;
        while (true) {
            // 모두 치즈가 녹았을때 탈출
            if (allMelt()) {
                break;
            }
            outAir = new boolean[n][m];
            checkOutAir(); // 바깥공기 체크
            melt(); // 치즈 녹기

            time++;
        }
        System.out.println(time);

    }

    // 녹는지점 확인
    private static void checkOutAir() {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        outAir[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !outAir[nx][ny] && board[nx][ny] == 0) {
                    outAir[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }

            }
        }
    }
    private static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 녹는점 확인
                if (board[i][j] == 1 && checkMelt(i, j)) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean checkMelt(int x, int y) {
        int cnt = 0;
        // 주변 변이 0인거나, 내부공기가 아닌게 2개이상이면 true
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && outAir[nx][ny] && board[nx][ny] == 0) {
                cnt++;
            }
        }
        return cnt >= 2;
    }

    private static boolean allMelt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;

    }


}
