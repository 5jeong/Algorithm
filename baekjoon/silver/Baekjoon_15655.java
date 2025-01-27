package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/***
 * N과 M(6)
 * N개 자연수 중 M개를 고른 수열
 * 오름차순인 수열만 골라야함 ex) 1 7 - (O) , 3 5 - (O), 4 2 - (X)
 * 오름차순으로 출력
 */
public class Baekjoon_15655 {
    static int n, m;
    static int[] num;
    static int[] ch;
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
        ch = new int[n];
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
            for (int i = s; i < n; i++) {
                res[L] = num[i];
                dfs(i + 1, L + 1);
            }
        }
    }

}
