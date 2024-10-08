package Algorithm_Study_Inflearn.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 숲속의기사 {
    static int r, c;
    static int[][] dis;
    static int[][] ch;
    static Queue<Point> queue;
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

    static void bfs(int[][] board) {
        ch = new int[r][c];
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point temp = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp.x + dx[dir];
                    int ny = temp.y + dy[dir];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != 1 && ch[nx][ny]==0) {
                        ch[nx][ny] =1;
                        queue.offer(new Point(nx, ny));
                        // 간곳 체크
                        dis[nx][ny] += L;
                    }
                }
            }
        }
    }

    public static int solution(int[][] board) {
        r = board.length;
        c = board[0].length;
        dis = new int[r][c];
        queue = new LinkedList<>();
        List<Point> berries = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    queue.offer(new Point(i, j));
                    bfs(board);
                }
                if (board[i][j] == 4) {
                    berries.add(new Point(i, j));
                }

            }
        }

        int ans = Integer.MAX_VALUE;
        for(Point berry : berries){
            int x = berry.x;
            int y = berry.y;
            if(dis[x][y] > 0 ){
                ans = Math.min(ans,dis[x][y]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

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
        System.out.println(solution(new int[][]{
                {4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }

}
