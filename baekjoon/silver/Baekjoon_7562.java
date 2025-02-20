package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 나이트의 이동
 */
public class Baekjoon_7562 {
    static int n, startX, startY, endX, endY;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 1, 2};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 2, 1};
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            board = new int[n][n];
            startX = sc.nextInt();
            startY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();
            sb.append(bfs()).append('\n');
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        board[startX][startY] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 8; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                        if (nx == endX && ny == endY) {
                            return L + 1;
                        }
                        board[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
        return 0;
    }
}
