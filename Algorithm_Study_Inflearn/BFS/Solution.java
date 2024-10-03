package Algorithm_Study_Inflearn.BFS;

import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;
    static int[][] dis;
    static int[][] cnt;
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
        int[][] ch = new int[r][c];
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                ch[temp.x][temp.y] = 1;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != 1 && board[nx][ny] != 3
                            && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        cnt[nx][ny]++;
                        queue.offer(new Point(nx, ny));
                        dis[nx][ny] += L;
                    }
                }
            }
        }
    }

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        r = board.length;
        c = board[0].length;

        // 영희와 산딸기 거리
        dis = new int[r][c];
        cnt = new int[r][c];
        queue = new LinkedList<>();
        List<Point> berries = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 영희 위치
                if (board[i][j] == 2) {
                    queue.offer(new Point(i, j));
                    bfs(board);
                }
                // 기사 위치
                if (board[i][j] == 3) {
                    queue.offer(new Point(i, j));
                    bfs(board);
                }
                if (board[i][j] == 4) {
                    berries.add(new Point(i, j));
                }

            }
        }
        for (Point point : berries) {
            int x = point.x;
            int y = point.y;
            if (dis[x][y] > 0 && cnt[x][y] == 2) {
                answer = Math.min(answer, dis[x][y]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}