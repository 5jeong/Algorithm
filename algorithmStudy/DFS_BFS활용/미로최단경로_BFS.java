package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 미로최단경로_BFS {
    static int[][] board;
    static int[][] dis;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;
    static Queue<Point> queue;

    static class Point {
        int x;
        int y;

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
                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[7][7];
        dis = new int[7][7];
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue = new LinkedList<>();
        board[0][0] =1;
        queue.add(new Point(0, 0));
        bfs();
        System.out.println(dis[6][6] == 0 ? -1 : dis[6][6]);
    }
}
