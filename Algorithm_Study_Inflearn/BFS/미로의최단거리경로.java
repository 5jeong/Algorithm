package Algorithm_Study_Inflearn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 미로의최단거리경로 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int L = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dist = new int[7][7];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        dist[nx][ny] = L;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        if (dist[6][6] != 0) {
            return dist[6][6];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(solution(arr));
    }
}

