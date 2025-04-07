package Promgrammers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    static int n, m, ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        ans = 0;
        n = maps.length;
        m = maps[0].length;

        ans = bfs(0, 0, maps);
        return ans;
    }

    private int bfs(int x, int y, int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                Point now = queue.poll();
                if (now.x == n - 1 && now.y == m - 1) {
                    return L;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                        maps[nx][ny] = 0;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        return -1;
    }
}
