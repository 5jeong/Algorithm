package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 그리디알고리즘
 * 돈이 가장 많은 동아리방이 돈이
 *
 */
public class Baekjoon_15317 {
    static int n, m, x;
    static int[] room, dong;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 동방 수
        m = sc.nextInt(); // 동아리 수
        x = sc.nextInt(); // 도울수있는 금액
        room = new int[n]; // 동방
        dong = new int[m]; // 동아리

        for (int i = 0; i < n; i++) {
            room[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            dong[i] = sc.nextInt();
        }

        Arrays.sort(room);
        Arrays.sort(dong);

        int ans = 0;
        int lt = 0;
        int rt = Math.min(n, m);

        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 동방을 가지는 동아리 갯수
            if (calcMinimumSupport(mid) < x) {
                ans = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(ans);

    }

    private static long calcMinimumSupport(int mid) {
        long res = 0;
        for (int i = 0; i < mid; i++) {
            res += Math.max(room[i] - dong[dong.length - mid + i], 0);
        }
        System.out.println("res = " + res);
        return res;
    }

}
