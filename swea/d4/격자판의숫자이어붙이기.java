package swea.d4;

import java.io.FileInputStream;
import java.util.*;

public class 격자판의숫자이어붙이기 {

    public static Set<String> nums;
    static int[][] board;
    static int[][] ch;
    static String num = "";
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int x, int y, String num) {
        if (nums.contains(num)) {
            return;
        }
        if (num.length() == 7) {
            nums.add(num);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                    dfs(nx, ny, num + board[nx][ny]);
                }
            }
        }

    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            nums = new HashSet<>();
            board = new int[4][4];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    num = "";
                    dfs(i, j, num + board[i][j]);
                }
            }
            System.out.println("#" + test_case + " " + nums.size());
        }
    }
}
