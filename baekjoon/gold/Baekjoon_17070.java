package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 파이프 옮기기1
public class Baekjoon_17070 {
    static int[] dx = {0, 1, 1}; // 가로, 대각선, 세로 순
    static int[] dy = {1, 1, 0};
    static int n, ans;
    static int[][] board;

    static class Point {
        int x, y, dir;

        Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // 목적지가 벽이면 불가능
        if (board[n - 1][n - 1] == 1) {
            System.out.println(0);
            return;
        }
        bfs(0, 1, 0);

        System.out.println(ans);
    }

    static void bfs(int x, int y, int dir) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, dir));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == n - 1 && now.y == n - 1) {
                ans++;
            }
            for (int i = 0; i < 3; i++) {
                if (now.dir == 0 && i == 2) {
                    // 현재 방향이 가로면 세로 불가능
                    continue;
                } else if (now.dir == 2 && i == 0) {
                    // 현재 방향이 세로면 가로 불가능
                    continue;
                }
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < n && ny < n && board[nx][ny] != 1) {
                    // 대각선이면 세칸 모두 비어져있어야하
                    if (i == 1) {
                        if ( board[nx][now.y] == 0 && board[now.x][ny] == 0) {
                            queue.add(new Point(nx, ny, i));
                        }
                    } else {
                        queue.add(new Point(nx, ny, i));
                    }
                }
            }
        }
    }
}
