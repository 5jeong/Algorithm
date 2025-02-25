package baekjoon.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1194 {
    static int n, m;
    static char[][] board;
    static int[][][] dis; // dis[keyState][x][y]
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y, keyState;

        Point(int x, int y, int keyState) {
            this.x = x;
            this.y = y;
            this.keyState = keyState;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        dis = new int[1 << 6][n][m]; // 열쇠 상태 6비트 (000000 ~ 111111)
        Point start = null;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '0') { // 시작점
                    start = new Point(i, j, 0);
                }
                Arrays.fill(dis[i], -1); // 방문 안한 곳 -1로 초기화
            }
        }

        int ans = bfs(start);
        System.out.println(ans);
    }

    private static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        dis[0][start.x][start.y] = 1; // 시작점은 1부터 시작

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x, y = now.y, nowKey = now.keyState;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == '#') {
                    continue;
                }

                char tile = board[nx][ny];

                switch (tile) {
                    case '1': // 출구
                        return dis[nowKey][x][y];

                    case '.':
                    case '0': // 빈 칸 또는 시작점
                        if (dis[nowKey][nx][ny] == -1) {
                            dis[nowKey][nx][ny] = dis[nowKey][x][y] + 1;
                            queue.offer(new Point(nx, ny, nowKey));
                        }
                        break;

                    case 'a', 'b', 'c', 'd', 'e', 'f': // 열쇠
                        int nextKey = nowKey | (1 << (tile - 'a'));
                        if (dis[nextKey][nx][ny] == -1) {
                            dis[nextKey][nx][ny] = dis[nowKey][x][y] + 1;
                            queue.offer(new Point(nx, ny, nextKey));
                        }
                        break;

                    case 'A', 'B', 'C', 'D', 'E', 'F': // 문
                        if ((nowKey & (1 << (tile - 'A'))) > 0 && dis[nowKey][nx][ny] == -1) {
                            dis[nowKey][nx][ny] = dis[nowKey][x][y] + 1;
                            queue.offer(new Point(nx, ny, nowKey));
                        }
                        break;
                }
            }
        }
        return -1;
    }
}
