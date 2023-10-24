package swea.d4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보급로 {
    static int n, ans;
    static Queue<Point> queue;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] dis;

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
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                int distance = dis[temp.x][temp.y] + board[nx][ny];
                if (dis[nx][ny] > distance) {
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = distance;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            board = new int[n][n];
            dis = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE);
            }
            queue = new LinkedList<>();
            ans = 0;
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }
            queue.add(new Point(0, 0));
            dis[0][0] = 0;
            bfs();
            System.out.println("#" + test_case + " " + dis[n - 1][n - 1]);
        }
    }
}
