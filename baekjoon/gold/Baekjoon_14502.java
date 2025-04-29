package baekjoon.gold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 연구소
public class Baekjoon_14502 {


    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] board;
    static int ans;
    static List<Point> empties;
    static List<Point> viruses;
    static int[] combi;

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
        empties = new ArrayList<>();
        viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                // 빈공간 모두 널기
                if (board[i][j] == 0) {
                    empties.add(new Point(i, j));
                }
                // 바이러스
                if (board[i][j] == 2) {
                    viruses.add(new Point(i, j));
                }
            }
        }
        ans = 0;
        combi = new int[3];
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int L, int s) {
        if (L == 3) {
            List<Point> temps = new ArrayList<>();
            for (int x : combi) {
                temps.add(empties.get(x));
            }
            int[][] tempBoard = change(temps);
            bfs(tempBoard);
            ans = Math.max(ans, findSafeZone(tempBoard));
        } else {
            for (int i = s; i < empties.size(); i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    private static int[][] change(List<Point> temps) {
        int[][] tempBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            tempBoard[i] = board[i].clone();
        }
        for (Point temp : temps) {
            tempBoard[temp.x][temp.y] = 1;
        }
        return tempBoard;
    }

    private static int findSafeZone(int[][] tempBoard) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempBoard[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 바이러스 확산 ( 임시보드판)
    private static void bfs(int[][] tempBoard) {
        Queue<Point> queue = new LinkedList<>(viruses);

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tempBoard[nx][ny] == 0) {
                    tempBoard[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
