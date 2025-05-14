package Promgrammers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 지게차와크레인 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static boolean[][] out;
    static List<Point> toRemove;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        board = new char[n + 2][m + 2];
        out = new boolean[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(board[i], ' ');
            Arrays.fill(out[i], true);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = storage[i - 1].charAt(j - 1);
                out[i][j] = false;
            }
        }

        for (String x : requests) {
            toRemove = new ArrayList<>();
            char temp = x.charAt(0); // 제거할 문자
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (board[i][j] == temp) {
                        if (x.length() == 2) {
                            board[i][j] = ' '; // 제거
                            out[i][j] = false;
                        } else {
                            if (isDelete(i, j)) {
                                toRemove.add(new Point(i, j));
                            }
                        }
                    }
                }
            }

            // 제거
            for (Point p : toRemove) {
                board[p.x][p.y] = ' ';
                out[p.x][p.y] = false;
            }

            // 외부 공기 다시 계산
            bfs();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] != ' ') {
                    answer++;
                }
            }
        }
        return answer;
    }

    // 제거할수 있는지 확인
    private boolean isDelete(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < n + 2 && ny >= 0 && ny < m + 2 && out[nx][ny]) {
                return true;
            }
        }
        return false;

    }

    //외부공기 탐색
    private void bfs() {
        Point p = new Point(0, 0);
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        boolean[][] visited = new boolean[n + 2][m + 2];

        while (!q.isEmpty()) {
            Point temp = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = temp.x + dx[dir];
                int ny = temp.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] != ' ') {
                    continue;
                }
                visited[nx][ny] = true;
                out[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }
}
