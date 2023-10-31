package swea.d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class 미로1 {
    static int[][] board;
    static int ans;
    static int end_x, end_y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y) {
        if (ans == 1) {
            return;
        }
        if (x == end_x && y == end_y) {
            ans = 1;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16 && ( board[nx][ny] == 0) || board[nx][ny] ==3) {
                board[nx][ny] = 1;
                dfs(nx, ny);
                board[nx][ny] = 0;
            }
        }

    }

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int t = sc.nextInt();
            board = new int[16][16];
            ans = 0;
            int start_x = 0, start_y = 0;
            for (int i = 0; i < 16; i++) {
                String str = sc.next();
                for (int j = 0; j < str.length(); j++) {
                    board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                    if (board[i][j] == 2) {
                        start_x = i;
                        start_y = j;
                    }
                    if (board[i][j] == 3) {
                        end_x = i;
                        end_y = j;
                    }
                }
            }
            dfs(start_x, start_y);
            System.out.println("#"+t+" "+ans);
        }

    }
}
