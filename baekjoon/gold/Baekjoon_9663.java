package baekjoon.gold;

import java.util.Scanner;

/***
 * N-Queen
 * N * N 크기의 체스판에 N개의 퀸을 배치하는 경우의 수 출력
 * 1. 한 행의 하나만 퀸만 넣어야 가능
 * 2. 마지막 행에 도달하면 +1
 * 3. 불가능할 경우 백트래킹
 */
public class Baekjoon_9663 {
    static int n;
    static int[] queen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queen = new int[n];
        System.out.println(dfs(0));
    }

    static int dfs(int x) {
        int cnt=0;
        if (x == n) {
            return 1;
        }
        for (int y = 0; y < n; y++) {
            if (isPossible(x, y)) {
                queen[x] = y;
                cnt += dfs(x+1);
            }
        }
        return cnt;
    }

    static boolean isPossible(int x, int y) {

        for (int i = 0; i < x; i++) {
            // 열체크
            if (queen[i] == y) {
                return false;
            }
            // 대각선 체크 ( 같은 스칼라만큼 떨어져있으면 대각선에 있음)
            if (Math.abs(x - i) == Math.abs(y - queen[i])) {
                return false;
            }
        }
        return true;
    }

}
