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
        while(t-- > 0){
            // 미세먼지 확산
            diffusion();
            // 공기청정기 가동
            air();
        }
        // t지난후 board에서 미세먼지 총 양 구 하기
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

    private static void air() {
        int[][] copy = new int[r][c];

        for (int i = 0; i < r; i++) {
            copy[i] = board[i].clone();
        }

        // 윗공기 밀기
        for (int i = 0; i < c - 1; i++) {
            board[upAir.x][i + 1] = copy[upAir.x][i];
        }

        for (int i = upAir.x; i > 0; i--) {
            board[i - 1][c - 1] = copy[i][c - 1];
        }

        for (int i = c - 1; i > 0; i--) {
            board[0][i - 1] = copy[0][i];
        }

        for (int i = 0; i < upAir.x; i++) {
            board[i + 1][0] = copy[i][0];
        }

        board[upAir.x][upAir.y] = -1;
        board[upAir.x][upAir.y + 1] = 0;

        // 아랫공기 밀기
        for (int i = 0; i < c - 1; i++) {
            board[downAir.x][i + 1] = copy[downAir.x][i];
        }

        for (int i = downAir.x; i < r - 1; i++) {
            board[i + 1][c - 1] = copy[i][c - 1];
        }

        for (int i = c - 1; i > 0; i--) {
            board[r - 1][i - 1] = copy[r - 1][i];
        }

        for (int i = r - 1; i > downAir.x; i--) {
            board[i - 1][0] = copy[i][0];
        }
        board[downAir.x][downAir.y] = -1;
        board[downAir.x][downAir.y + 1] = 0;
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
        int[][] temp = new int[r][c]; // 퍼진 먼지를 임시로 저장할 배열

        Queue<Point> queue = new LinkedList<>(findDust());
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int amount = board[now.x][now.y] / 5;
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (isNotDiffusion(nx, ny)) {
                    continue;
                }
                temp[nx][ny] += amount;
                board[nx][ny] -= amount;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] += temp[i][j];
            }
        }

    }

    private static boolean isNotDiffusion(int nx, int ny) {
        if (nx < 0 || nx >= r || ny < 0 || ny >= c || board[nx][ny] == -1) {
            return true;
        }
        return false;
    }
}
