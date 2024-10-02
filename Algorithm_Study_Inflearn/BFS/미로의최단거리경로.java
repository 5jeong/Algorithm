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
        int L = 0;
        Queue<Point> queue = new LinkedList<>();
        int n = 7;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx == n - 1 && ny == n - 1) {
                        return L;
                    }
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
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
        System.out.println(solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}}));
    }


}

