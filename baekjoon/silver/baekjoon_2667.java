package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2667 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] board;
    static int[][] ch;

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
        board = new int[n][n];
        ch = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        int cnt = 0; // 단지 갯수
        ArrayList<Integer> houseCnt = new ArrayList<>();

        // 방문여부 체크 및 bfs탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j] == 0 && board[i][j] == 1) {
                    ch[i][j] = 1;
                    houseCnt.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(houseCnt);
        for (Integer x : houseCnt) {
            System.out.println(x);
        }
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList();
        queue.offer(new Point(x, y));
        int houseCnt = 1;

        while (!queue.isEmpty()) {

            Point temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1 && ch[nx][ny] ==0){
                    ch[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    houseCnt++;
                }
            }
        }

        return houseCnt;
    }
}
