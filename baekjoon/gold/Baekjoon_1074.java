package baekjoon.gold;

import java.util.Scanner;

/***
 * Z
 * 좌상단, 우상단, 좌하단, 좌상단 순으로 분할 정복
 */
public class Baekjoon_1074 {
    static int n, r, c;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        ans = 0;
        findZ(n, r, c);
        System.out.println(ans);
    }

    static void findZ(int n, int x, int y) {
        if(n==0){
            return;
        }
        int size = (int) Math.pow(2, n);
        int mid = size / 2;

        // 좌 상단
        if (x < mid && y < mid) {
            findZ(n - 1, x, y);
        }
        // 우 상단
        if (x < mid && y >= mid) {
            ans += (mid * mid);
            findZ(n - 1, x, y - mid);
        }
        // 좌 하단
        if (x >= mid && y < mid) {
            ans += (mid * mid) * 2;
            findZ(n - 1, x - mid, y);
        }
        // 우 하단
        if (x >= mid && y >= mid) {
            ans += (mid * mid) * 3;
            findZ(n - 1, x - mid, y - mid);
        }
    }
}
