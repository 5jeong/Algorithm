package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기
 */
public class Baekjoon_2206 {
    static int n, m, ans;
    static int[][] board;
    static int[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y, isBroken;

        Point(int x, int y, int isBroken) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
        }
    }

    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }
        ans = bfs(board);

        System.out.println(ans);
    }

    static int bfs(int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0));
        visited[0][0][0] = 1;

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point now = queue.poll();
                int isBroken = now.isBroken;
                if (now.x == n - 1 && now.y == m - 1) {
                    return L;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    // 빈 칸(0)으로 이동 가능
                    if (board[nx][ny] == 0 && visited[nx][ny][isBroken] == 0) {
                        visited[nx][ny][isBroken] = 1;
                        queue.offer(new Point(nx, ny, isBroken));
                    }
                    // 벽(1)이고 아직 벽을 부순 적이 없는 경우
                    else if (board[nx][ny] == 1 && isBroken == 0) {
                        visited[nx][ny][1] = 1;
                        queue.offer(new Point(nx, ny, 1));
                    }
                }
            }
        }
        return -1;
    }
}
