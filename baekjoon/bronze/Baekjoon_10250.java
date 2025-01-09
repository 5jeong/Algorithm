package baekjoon.bronze;

import java.util.Scanner;

public class Baekjoon_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int y = (n - 1) / h; // 호
            int x = (n - 1) % h; // 층

            System.out.println((x + 1) * 100 + y + 1);

//            solution(w, h, n);
        }
    }

    private static void solution(int w, int h, int n) {
        int[][] board = new int[w][h];
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                board[x][y] = (y + 1) * 100 + (x + 1);
            }
        }
        System.out.println(board[(n - 1) / h - 1][(n - 1) % h]);
    }
}
