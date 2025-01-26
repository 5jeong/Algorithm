package baekjoon.silver;

import java.util.Scanner;

/**
 * N과 M (1)
 * 중복 없는 수열
 * 순서가 다르면 다른 수열
 */
public class Baekjoon_15649 {
    static int n, m;
    static int[] ch;
    static int[] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        res = new int[m];
        dfs(0);
    }

    static void dfs(int L) {
        if (L == m) {
            for(int x : res){
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    res[L] = i;
                    dfs(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
