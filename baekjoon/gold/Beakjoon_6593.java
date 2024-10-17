package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon_6593 {
    static int l, r, c;
    static char[][][] board;
    static int[][][] dis;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Point> queue;

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static void bfs() {
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 6; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    int nz = temp.z + dz[dir];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && nz >= 0 && nz < l) {
                        if (board[nz][nx][ny] != '#') {
                            board[nz][nx][ny] = '#';
                            dis[nz][nx][ny] = L;
                            queue.offer(new Point(nx, ny, nz));
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            board = new char[l][r][c];
            dis = new int[l][r][c];
            Point res = null;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = s.charAt(k);
                        if (board[i][j][k] == 'S') {
                            queue.offer(new Point(j, k, i));
                        }
                        if (board[i][j][k] == 'E') {
                            res = new Point(j, k, i);
                        }
                    }
                }
                br.readLine();
            }
            bfs();
            int ans = dis[res.z][res.x][res.y];
            if (ans == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %s minute(s).", ans);
                System.out.println();
            }
        }
    }
}
