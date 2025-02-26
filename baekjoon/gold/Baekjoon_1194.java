package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 달이 차오른다, 가자
 */
public class Baekjoon_1194 {

    static final int EMPTY = 1;
    static final int KEY = 2;
    static final int DOOR = 3;
    static final int EXIT = 4;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static char[][] board;
    static boolean[][][] visited;
    static Point start;

    static class Point {
        int x, y, keyState;

        Point(int x, int y, int keyState) {
            this.x = x;
            this.y = y;
            this.keyState = keyState;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];
        visited = new boolean[1 << 6][n][m]; // 열쇠 상태 6비트 (000000 ~ 111111)
        start = null;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '0') {
                    start = new Point(i, j, 0);
                }
            }
        }
        int ans = bfs();
        System.out.println(ans);

    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[0][start.x][start.y] = true; // 시작점은 1부터 시작
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point now = queue.poll();
                int x = now.x;
                int y = now.y;
                int nowKey = now.keyState;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == '#') {
                        continue;
                    }

                    switch (findType(board[nx][ny])) {
                        case EXIT -> {
                            return L + 1;
                        }
                        case EMPTY -> {
                            if (!visited[nowKey][nx][ny]) { // 방문한 적 없는경우
                                queue.offer(new Point(nx, ny, nowKey));
                                visited[nowKey][nx][ny] = true;
                            }
                        }
                        case KEY -> {
                            int nextKey = nowKey | (1 << (board[nx][ny] - 'a'));
                            if (!visited[nextKey][nx][ny]) { // 방문 한적 없는 경우
                                queue.offer(new Point(nx, ny, nextKey));
                                visited[nextKey][nx][ny] = true;
                            }
                        }
                        case DOOR -> {
                            int open = nowKey & (1 << (board[nx][ny] - 'A'));
                            if (open > 0 && !visited[nowKey][nx][ny]) { // 열쇠가 있어 문을 열수 있는 경우
                                queue.offer(new Point(nx, ny, nowKey));
                                visited[nowKey][nx][ny] = true;
                            }
                        }
                    }
                }
            }
            L++;
        }
        return -1;
    }

    private static int findType(char c) {
        if (c == '.' || c == '0') {
            return EMPTY;
        } else if (c >= 'a' && c <= 'f') {
            return KEY;
        } else if (c >= 'A' && c <= 'F') {
            return DOOR;
        } else if (c == '1') {
            return EXIT;
        }
        return -1;
    }
}