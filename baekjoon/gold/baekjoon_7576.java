package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * M : 가로, N : 세로
 * 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토X
 * 모두 다익는 최소 일수 구하기
 * 1을 모두 큐에 넣기
 */
public class baekjoon_7576 {
    static int n, m;
    static int[][] board;
    static int[][] dis;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<Point> queue;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = temp.x + dx[dir];
                int ny = temp.y + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = -1;
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = Integer.MIN_VALUE;
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new int[n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }
        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    ans = Math.max(ans, dis[i][j]);
                }
            }
        }
        System.out.println(ans);

    }
}
