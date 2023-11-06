package swea.d4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 정사각형방 {
    static int[][] board;
    static int[][] dis;
    static int n, ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static void bfs(int x, int y) {
        int num = board[x][y] + 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int distance = 1;
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == num) {
                    queue.add(new Point(nx, ny));
                    distance++;
                }
            }
            num++;
        }
        dis[x][y] = distance;
        ans = Math.max(ans, dis[x][y]);
    }

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            board = new int[n][n];
            dis = new int[n][n];
            int roomNum = Integer.MAX_VALUE;
            ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                Arrays.fill(dis[i], 1);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bfs(i, j);
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][j] == ans) {
                        roomNum = Math.min(roomNum, board[i][j]);
                    }
                }
            }
            System.out.println("#" + test_case + " " + roomNum + " " + ans);

        }

    }
}
