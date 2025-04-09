package Promgrammers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {
    static int n, m;
    static int cnt;
    static Point character, item;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        n = 100;
        m = 100;
        board = new int[n + 1][m + 1];
        character = new Point(characterY * 2, characterX * 2);
        visited = new boolean[n + 1][m + 1];
        item = new Point(itemY * 2, itemX * 2);
        cnt = 0;
        for (int[] arr : rectangle) {
            int x1 = arr[1];
            int y1 = arr[0];
            int x2 = arr[3];
            int y2 = arr[2];
            draw(new Point(x1 * 2, y1 * 2), new Point(x2 * 2, y2 * 2));
        }

        int ans = bfs(character, item);

        return ans;
    }

    private void draw(Point p1, Point p2) {

        for (int i = p1.x; i <= p2.x; i++) {
            for (int j = p1.y; j <= p2.y; j++) {
                if (board[i][j] == 1) {
                    continue;
                }
                board[i][j] = 1;
                if (i == p1.x || i == p2.x || j == p1.y || j == p2.y) {
                    board[i][j] = 2;
                }
            }
        }
    }


    private int bfs(Point character, Point item) {
        int L = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(character);
        visited[character.x][character.y] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;

            for (int i = 0; i < len; i++) {
                Point now = queue.poll();
                if (now.x == item.x && now.y == item.y) {
                    return L / 2;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && !visited[nx][ny] && board[nx][ny] == 2) {
                        visited[nx][ny] = true; // 방문처리
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return -1;

    }
}
