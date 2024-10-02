package Algorithm_Study_Inflearn.BFS;

import java.util.*;

class Solution {
    static int[][] dis;
    static int[][] ch;
    static int n, emptyLand;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
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
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand) {
                        board[nx][ny]--;
                        queue.offer(new Point(nx, ny));
                        dis[nx][ny] += L;
                    }
                }
            }
        }
        emptyLand--;
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        n = board.length;
        emptyLand = 0;
        dis = new int[n][n];
        queue = new LinkedList<>();
        ch = new int[n][n];

        // 빌딩(1) 지점에서 bfs , 거리누적하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    bfs(board);
                }
            }
        }

        // 모두방문한곳에서 최소거리 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == emptyLand && dis[i][j] > 0) {
                    answer = Math.min(answer, dis[i][j]);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(
                new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}