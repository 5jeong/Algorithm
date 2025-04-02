package baekjoon.gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_1261 {
    static int m, n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;
        int cnt; // 벽부순 갯수

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            for (int j = 1; j <= m; j++) {
                board[i][j] = s.charAt(j-1) - '0';
            }
        }
        int ans = bfs();
        System.out.println(ans);


    }

    static int bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
        pq.add(new Point(1, 1, 0));
        visited[1][1] = true;

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            // 정답 발견
            if (now.x == n && now.y == m) {
                return now.cnt;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (nx <= 0 || nx > n || ny <= 0 || ny > m) {
                    continue;
                }
                // 벽인경우
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, now.cnt + 1));
                }
                if (!visited[nx][ny] && board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, now.cnt));
                }
            }
        }
        return 0;
    }
}
