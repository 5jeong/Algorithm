package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***
 * 빙산이 주어질때 모든 좌표 탐색
 * 두덩이 이상이 될때까지 bfs로 빙산 업데이트
 * 좌표 유효성 검사 안해도 보장
 */
public class Baekjoon_2573 {
    static int n, m;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    if (isAnswer()) {
                        System.out.println(ans);
                        return;
                    } else {
                        visited = new int[n][m];
                        bfs(i, j);
                        ans++;
                    }
                }
            }
        }
        System.out.println(0);
    }

    // 빙산 업데이트
    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = 1;
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx < 0 && nx >= n && ny < 0 && ny >= m) {
                    continue;
                }
                if (board[nx][ny] != 0 && visited[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = 1;
                } else if (board[nx][ny] == 0 && visited[nx][ny] == 0) {
                    board[temp.x][temp.y]--;
                    if (board[temp.x][temp.y] < 0) {
                        board[temp.x][temp.y] = 0;
                    }
                }
            }
        }
    }

    // 분리된 빙산 개수 찾기
    static boolean isAnswer() {
        int cnt = 0;
        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0 && ch[i][j]==0) {
                    cnt++;
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(i, j));
                    ch[i][j]=1;
                    while (!queue.isEmpty()) {
                        Point temp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = temp.x + dx[k];
                            int ny = temp.y + dy[k];
                            if(nx>=0 && nx < n && ny>=0 && ny < m && board[nx][ny]!=0 && ch[nx][ny] == 0){
                                ch[nx][ny]=1;
                                queue.offer(new Point(nx,ny));
                            }
                        }
                    }
                }
            }
        }
        return cnt >= 2;
    }
}
