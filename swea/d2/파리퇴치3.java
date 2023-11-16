package swea.d2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class 파리퇴치3 {

    static int[][] arr;
    static int n, m;

    static int catch1(int x, int y) {
        int catch1 = 0;
        for (int i = x - m + 1; i < x + m; i++) {
            for (int j = y - m + 1; j < y + m; j++) {
                if (check(i, j)) {
                    if (i == x) {
                        catch1 += arr[i][j];
                    }
                    if (j == y) {
                        catch1 += arr[i][j];
                    }

                }
            }
        }
        catch1 -= arr[x][y];
        return catch1;
    }

    static int catch2(int x, int y) {
        int catch2 = 0;
        int k = x + y;
        int k2 = x - y;
        for (int i = x - m + 1; i < x + m; i++) {
            for (int j = y - m + 1; j < y + m; j++) {
                if (check(i, j)) {
                    if (k == i + j) { // 대각선(/) 합
                        catch2 += arr[i][j];
                    }
                    if (k2 == i - j) {
                        catch2 += arr[i][j]; // 대각선(\) 합
                    }

                }
            }
        }
        catch2 -= arr[x][y];
        return catch2;

    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d2\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp1 = catch1(i, j);
                    int temp2 = catch2(i, j);
                    int temp = Math.max(temp1, temp2);
                    ans = Math.max(ans, temp);

                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}
