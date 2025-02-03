package baekjoon.silver;

import java.util.Scanner;

/***
 * 곱셈
 * 분할정복
 */
public class Baekjoon_1629 {
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        c = sc.nextInt();

        long result = dfs(a, b);
        System.out.println(result);
    }

    static long dfs(int a, int b) {
        // 정복
        if (b == 1) {
            return a % c;
        }
        // 분할
        long half = dfs(a, b / 2);

        // 조합
        // b가 짝수 일때
        if (b % 2 == 0) {
            return half * half % c;
        }
        // b가 홀수 일때
        else {
            return ((half * half) % c) * a % c;
        }
    }
}
