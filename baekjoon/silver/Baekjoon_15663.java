package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/***
 * N과 M(9)
 * N개 자연수 중 M개를 고른 수열
 * 중복되는 수열 여러번 출력x
 * 오름차순으로 출력
 */
public class Baekjoon_15663 {
    static int n, m;
    static int[] num;
    static int[] res;
    static int[] ch;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();
        num = new int[n];
        ch = new int[10001];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        res = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int L) {

        if (L == m) {
            for (int x : res) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            int before = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    continue;
                }
                if (before != num[i]) {
                    ch[i] = 1;
                    res[L] = num[i];
                    before = num[i];
                    dfs(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}


