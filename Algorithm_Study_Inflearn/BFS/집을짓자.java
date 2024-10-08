package Algorithm_Study_Inflearn.BFS;


import java.util.LinkedList;
import java.util.Queue;

public class 집을짓자 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;
    static int n, ch;
    static int[][] dis;
    static Queue<Point> queue;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int[][] board) {
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == ch) {
                        queue.offer(new Point(nx, ny));
                        board[nx][ny] -= 1;
                        dis[nx][ny] += L;
                    }
                }
            }
        }
        ch--;
    }

    public static int solution(int[][] board) {
        n = board.length;
        dis = new int[n][n];
        ans = Integer.MAX_VALUE;
        ch = 0;
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    bfs(board);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ch && dis[i][j] > 0) {
                    ans = Math.min(ans, dis[i][j]);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
