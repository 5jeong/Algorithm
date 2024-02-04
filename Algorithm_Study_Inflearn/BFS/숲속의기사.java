package Algorithm_Study_Inflearn.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 숲속의기사 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int r = board.length;
        int c = board[0].length;
        int[][] dist = new int[r][c];
        int[][] ch;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    int L = 0;
                    queue.offer(new Point(i, j));
                    ch = new int[r][c];
                    ch[i][j] = 1;
                    while (!queue.isEmpty()) {
                        L++;
                        int len = queue.size();
                        for (int s = 0; s < len; s++) {
                            Point temp = queue.poll();
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = temp.x + dx[dir];
                                int ny = temp.y + dy[dir];
                                if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != 1 && ch[nx][ny] == 0) {
                                    ch[nx][ny] = 1;
                                    dist[nx][ny] += L;
                                    queue.offer(new Point(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 4 && dist[i][j] > 0) {
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }

}
