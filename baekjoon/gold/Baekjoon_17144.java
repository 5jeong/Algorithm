package baekjoon.gold;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 미세먼지 안녕

// 0. time만큰 반복
//     1. 미세먼지 동시에 확산한 board구하기(bfs)+ visited
//     2. 공기청정기 실행 board 정리,
// 3. time일때 양수값 리턴

public class Baekjoon_17144 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] visited;
    static int[][] board;
    static int r, c, t;
    static List<Point> airPoint;
    static Point upAir;
    static Point downAir;


    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    /***
     * 3 3 1
     * 0 30 7
     * -1 10 0
     * -1 0 20
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        board = new int[r][c];
        airPoint = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = sc.nextInt();
                //공기 청정기 위치
                if (board[i][j] == -1) {
                    airPoint.add(new Point(i, j));
                }
            }
        }

        upAir = airPoint.get(0);
        downAir = airPoint.get(1);

        // t시간만큼 반복
        for (int i = 1; i <= t; i++) {
            // 미세먼지 확산
            diffusion();
            // 공기청정기 가동
            air(i);
        }
        // t지난후 board에서 미세먼지 총 양구 하기
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] > 0) {
                    ans += board[i][j];
                }
            }
        }
        System.out.println(ans);
    }

    private static void air(int t) {
        // 한칸식 민다.
        int[][] copy = new int[r][c];

        for (int i = 0; i < r; i++) {
            copy[i] = board[i].clone();
        }

        // 윗공기 밀기
        board[0][0] =
        for(int i=1;i<c;i++){
            board[upAir.x][i] = board[upAir.x][i];
            board[0][i] = board[0][i+1];
        }




        // 아랫공기 밀기
    }

    // 미세먼지 찾기
    private static List<Point> findDust() {
        List<Point> dusts = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //공기 청정기 위치
                if (board[i][j] > 0) {
                    dusts.add(new Point(i, j));
                }
            }
        }
        return dusts;
    }

    private static void diffusion() {
        int[][] copy = new int[r][c];

        for (int i = 0; i < r; i++) {
            copy[i] = board[i].clone();
        }

        int[][] visited = new int[r][c];

        Queue<Point> queue = new LinkedList<>(findDust());
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            visited[now.x][now.y] = 1;
            int diffusionCnt = 0;
            List<Point> temp = new ArrayList<>(); // 주변 확산되는 위치
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                // 칸이없거나 공기청정기 위치일때,,
                if (isNotDiffusion(nx, ny)) {
                    continue;
                }
                diffusionCnt++;
                temp.add(new Point(nx, ny));
            }

            // 확산되는양
            int diffusionAmount = copy[now.x][now.y] / 5; // 확산되는양
            int nowDust = copy[now.x][now.y] - (diffusionAmount * diffusionCnt); // 현재 위치의 미세먼지 양

            board[now.x][now.y] = nowDust;
            for (Point p : temp) {
                board[now.x][now.y] += copy[p.x][p.y] / 5;
                if (visited[p.x][p.y] == 0) {
                    board[p.x][p.y] += diffusionAmount;
                }
            }
        }
    }

    private static boolean isNotDiffusion(int nx, int ny) {
        if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
            return true;
        }
        for (Point p : airPoint) {
            if (p.x == nx && p.y == ny) {
                return true;
            }
        }
        return false;
    }
}
