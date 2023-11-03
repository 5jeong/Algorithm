package swea.d4;

import java.io.FileInputStream;
import java.util.*;

public class 파핑파핑지뢰찾기 {

    static int n, ans;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static char[][] board;
    static char[][] ch;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == '*') {
                return false;
            }
        }
        return true;
    }

    static void bfs(int x, int y) {
        board[x][y] = '0';
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != '*') {
                    board[nx][ny] = '0';
                    if (check(nx, ny) && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }

        }

    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;
            n = sc.nextInt();
            board = new char[n][n];
            ch = new char[n][n];
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (check(i, j) && board[i][j] == '.') {
                        ch[i][j] = 1;
                        bfs(i, j);
                        ans++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.') {
                        ans++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + ans);

        }
    }
}
