package Promgrammers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class 석유시추 {
    static int n, m, groupId;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    static int[][] dis;
    static int[][] group;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        groupId = 1;
        visited = new int[n][m];
        dis = new int[n][m];
        group = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, land);
                    groupId++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int gid = group[j][i];
                if (gid != 0 && !set.contains(gid)) {
                    set.add(gid);
                    cnt += dis[j][i];
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }


    static void bfs(int x, int y, int[][] land) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> points = new ArrayList<>();
        points.add(new Point(x, y));
        queue.add(new Point(x, y));
        visited[x][y] = 1;
        int L = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    points.add(new Point(nx, ny));
                    L++;
                }
            }
        }

        for (Point p : points) {
            dis[p.x][p.y] = L;
            group[p.x][p.y] = groupId;
        }
    }
}
