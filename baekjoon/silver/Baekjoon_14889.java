package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_14889 {
    static int n, ans;
    static int[][] board;
    static int[] ch;

    static void sum(List<Integer> start, List<Integer> link) {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                startSum += board[start.get(i)][start.get(j)] + board[start.get(j)][start.get(i)];
                linkSum += board[link.get(i)][link.get(j)] + board[link.get(j)][link.get(i)];
            }
        }
        ans = Math.min(ans, Math.abs(startSum - linkSum));
    }

    static void dfs(int L, int s) {
        if (L == n / 2) {
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    start.add(i);
                } else {
                    link.add(i);
                }
            }
            sum(start, link);

        } else {
            for (int i = s; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = Integer.MAX_VALUE;
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);

    }
}
