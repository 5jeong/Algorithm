package Algorithm_Study_Inflearn.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 집을짓자 {
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dist = new int[n][n];
        int[][] ch;
        Queue<Point> queue;
        ArrayList<Point> buildings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    buildings.add(new Point(i, j));
                }
            }
        }
        int emptyLand = 0;
        for (Point building : buildings) {
            int L = 0;
            ch = new int[n][n];
            queue = new LinkedList<>();
            queue.offer(building);
            ch[building.x][building.y] = 1;
            while (!queue.isEmpty()) {
                L++;
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Point temp = queue.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = temp.x + dx[dir];
                        int ny = temp.y + dy[dir];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand) {
                            board[nx][ny]--;
                            dist[nx][ny] += L;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            emptyLand--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == emptyLand && dist[i][j] > 0) {
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
