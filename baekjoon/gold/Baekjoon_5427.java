package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_5427 {
    static int ans, w, h;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static int[][] dis;
    static int[][] visited;
    static Queue<Point> queue;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            dis = new int[h][w];
            visited = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < w; j++) {
                    board[i][j] = s.charAt(j);
                }
            }

            // 불 bfs
            queue = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == '*') {
                        queue.offer(new Point(i, j));
                    }
                }
            }
            fire();

            // 상근 bfs
            queue = new LinkedList<>();
            visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == '@') {
                        queue.offer(new Point(i, j));
                    }
                }
            }
            escape();

        }
        System.out.println(sb);
    }

    static void fire() {

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] != '#' && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        dis[nx][ny] = Math.min(dis[nx][ny], L + 1);
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
    }

    static void escape() {

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(L+1).append("\n");
                        return;
                    }
                    if (board[nx][ny] == '.' && dis[nx][ny] > L+1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
}
