package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_5427 {
    static int w, h;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static int[][] fireTime; // 불이 도달하는 최소시간
    static int[][] visited;
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
            fireTime = new int[h][w];
            visited = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(fireTime[i], Integer.MAX_VALUE);
            }

            List<Point> fires = new ArrayList<>();
            Point start = null;

            for (int i = 0; i < h; i++) {

                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = s.charAt(j);
                    if (board[i][j] == '*') {
                        fires.add(new Point(i, j));
                    }
                    if (board[i][j] == '@') {
                        start = new Point(i, j);
                    }
                }
            }

            // 불 bfs
            fire(fires);

            // 상근 bfs
            escape(start);

        }
        System.out.println(sb);
    }

    static void fire(List<Point> fires) {
        Queue<Point> queue = new LinkedList<>();
        for (Point fire : fires) {
            queue.offer(fire);
            fireTime[fire.x][fire.y] = 0;
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] != '#'
                            && fireTime[nx][ny] == Integer.MAX_VALUE) {
                        fireTime[nx][ny] = fireTime[temp.x][temp.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    static void escape(Point start) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = 1;

        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            time++;
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    // 탈출 성공
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(time).append("\n");
                        return;
                    }
                    // 이동 가능 여부 확인
                    if (board[nx][ny] == '.' && fireTime[nx][ny] > time  && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
}
