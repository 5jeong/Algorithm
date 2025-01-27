package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/***
 * N과 M(7)
 * N개 자연수 중 M개를 고른 수열
 * 같은 수 여러번 골라도 됨(중복o) ex) 1 1 , 2 2, 3 3
 * 오름차순으로 출력
 */
public class Baekjoon_15656 {
    static int n, m;
    static int[] num;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        res = new int[m];

        dfs( 0);
        System.out.println(sb);
    }

    private static void dfs( int L) {
        if (L == m) {
            for (int x : res) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
                res[L] = num[i];
                dfs( L + 1);
            }
        }
    }

}
