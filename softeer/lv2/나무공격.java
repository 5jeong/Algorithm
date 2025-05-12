package softeer.lv2;

import java.util.Scanner;

public class 나무공격 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 2번 공격(완탐)
        for (int i = 0; i < 2; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start - 1; j < end; j++) {
                for (int s = 0; s < m; s++) {
                    if (board[j][s] == 1) {
                        board[j][s] = 0;
                        break;
                    }
                }
            }

        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);


    }
}
