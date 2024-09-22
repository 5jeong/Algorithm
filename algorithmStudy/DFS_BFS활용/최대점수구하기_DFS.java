package algorithmStudy.DFS_BFS활용;

import java.io.IOException;
import java.util.Scanner;

public class 최대점수구하기_DFS {

    static int n, m;
    static int ans = Integer.MIN_VALUE;
    static int[] score;
    static int[] time;

    private static void dfs(int L, int sum, int timeSum) {
        if (timeSum > m) {
            return;
        }
        if (L == n) {
            ans = Math.max(ans, sum);
        } else {
            dfs(L + 1, sum + score[L], timeSum + time[L]);
            dfs(L + 1, sum, timeSum);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        dfs(0, 0, 0);
        System.out.println(ans);
    }
}
