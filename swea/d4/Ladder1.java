package swea.d4;

import java.io.FileInputStream;
import java.util.*;

public class Ladder1 {

    static int[][] board;
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};
    static int ans;

    static void bfs(int x, int y) {
        while (true) {
            if (x == 0) {
                ans = y;
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && board[nx][ny] == 1) {
                    board[nx][ny] = -1;
                    x = nx;
                    y = ny;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int t = sc.nextInt();
            board = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            ans = 0;
            for (int i = 0; i < 100; i++) {
                if (board[99][i] == 2) {
                    bfs(99, i);
                }
            }
            System.out.println("#" + t + " " + ans);
        }

    }
}
