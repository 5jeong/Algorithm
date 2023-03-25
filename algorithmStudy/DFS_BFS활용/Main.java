package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans = Integer.MIN_VALUE;
    static int[] score;
    static int[] time;

    static void DFS(int L, int time_sum, int score_sum) {
        if (time_sum > m) {
            return;
        }
        if (L == n) {
            if (score_sum > ans) {
                ans = score_sum;
            }
        }
        else {
            DFS(L + 1, time_sum + time[L], score_sum + score[L]);
            DFS(L + 1, time_sum, score_sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0, 0);
        System.out.println(ans);
    }
}