package baekjoon.silver;

import java.util.Scanner;

/***
 * 연산자 끼워넣기
 * dfs로 완탐, 최대,최소 구하기.
 */
public class Baekjoon_14888 {
    static int n;
    static int[] num;
    static int[] ch;
    static int[] cal = new int[4];
    static int max, min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 수의 개수
        num = new int[n]; // 수
        ch = new int[n];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        // 수식 개수
        for (int i = 0; i < 4; i++) {
            cal[i] = sc.nextInt();
        }
        ch[0] = 1;
        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int L, int result) {

        if (L == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        } else {
            // 4개의 수식
            for (int j = 0; j < 4; j++) {
                if (cal[j] > 0) {
                    dfs(L + 1, calculate(result, num[L], j));
                    // 연산자 갯수 복구
                    cal[j]++;
                }
            }
        }
    }


    static int calculate(int now, int next, int idx) {
        if (idx == 0) {
            cal[idx]--;
            return now + next;
        } else if (idx == 1) {
            cal[idx]--;
            return now - next;
        } else if (idx == 2) {
            cal[idx]--;
            return now * next;
        } else {
            cal[idx]--;
            return now / next;
        }
    }
}
