package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/***
 * N과 M(12)
 * N개 자연수 중 M개를 고른 수열
 * 같은수 여러번 가능
 * 오름차순 수열만 가능
 * 오름차순으로 출력
 */
public class Baekjoon_15666 {
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

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int s, int L) {

        if (L == m) {
            for (int x : res) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            int before = 0;
            for (int i = s; i < n; i++) {
                if (before != num[i]) {
                    res[L] = num[i];
                    before = num[i];
                    dfs(i, L + 1);
                }
            }
        }
    }
}


