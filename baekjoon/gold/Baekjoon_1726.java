package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 로봇
public class Baekjoon_1726 {
    static int[] dx = {0, 0, 0, 1, -1}; // 동 서 남 북
    static int[] dy = {0, 1, -1, 0, 0}; // 1  2  3  4
    static int m, n;
    static int[][] board;
    static int[][][] dis;
    static boolean[][][] visited;
    static Point start, end;

    static class Point {
        int x, y, dir;

        Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[m + 1][n + 1];
        dis = new int[m + 1][n + 1][5]; // 방향 추가..
        visited = new boolean[m + 1][n + 1][5];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        visited[start.x][start.y][start.dir] =true;
        bfs();
        System.out.println(dis[end.x][end.y][end.dir]);

    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowDir = now.dir;
            for (int j = 1; j <= 3; j++) {
                int nx = now.x + dx[nowDir] * j;
                int ny = now.y + dy[nowDir] * j;
                if (nx <= 0 || nx > m || ny <= 0 || ny > n || board[nx][ny] == 1) {
                    break;
                }
                if (!visited[nx][ny][nowDir]) {
                    visited[nx][ny][nowDir] = true;
                    dis[nx][ny][nowDir] = dis[now.x][now.y][nowDir] + 1;
                    queue.offer(new Point(nx, ny, nowDir));
                }
            }
            //회전 탐색
            for (int dir = 1; dir <= 4; dir++) {
                // 현재 방향이랑 같거나 방문했으면 continue
                if (dir == nowDir || visited[now.x][now.y][dir]) {
                    continue;
                }
                int cnt = switch (dir) {
                    // 동, 서
                    case 1, 2 -> (nowDir == 3 || nowDir == 4) ? 1 : 2;
                    // 남, 북
                    case 3, 4 -> (nowDir == 1 || nowDir == 2) ? 1 : 2;
                    default -> 0;
                };
                dis[now.x][now.y][dir] = dis[now.x][now.y][nowDir] + cnt;
                visited[now.x][now.y][dir] = true;
                queue.offer(new Point(now.x, now.y, dir));
            }

        }
    }
}

