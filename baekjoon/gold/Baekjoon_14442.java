package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 2
 */
public class Baekjoon_14442 {
    static int n, m, k;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][][] visited;

    static class Point {
        int x, y, brokenCnt;

        Point(int x, int y, int brokenCnt) {
            this.x = x;
            this.y = y;
            this.brokenCnt = brokenCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        int ans = bfs();
        System.out.println(ans);

    }

    static int bfs() {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0));
        visited[0][0][0] = 1;
        int L = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point now = queue.poll();
                int brokenCnt = now.brokenCnt;
                if (now.x == n - 1 && now.y == m - 1) {
                    return L;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    // 벽 부시지않고 가는 경우
                    if (board[nx][ny] == 0 && visited[nx][ny][brokenCnt] == 0) {
                        visited[nx][ny][brokenCnt]++;
                        queue.offer(new Point(nx, ny, brokenCnt));
                    }
                    // 벽 부시는 횟수가 남아있고, 벽을 부술수 있는경우
                    else if (board[nx][ny] == 1 && brokenCnt < k && visited[nx][ny][brokenCnt + 1] == 0) {
                        visited[nx][ny][brokenCnt + 1]++;
                        queue.offer(new Point(nx, ny, brokenCnt + 1));
                    }
                }
            }
            L++;
        }
        return -1;
    }
}
