package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon_2210 {
    static int[][] board;
    static int n = 5;
    static int ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Set<String> set;

    static void dfs(int L, int x, int y, String s) {

        if(set.contains(s)){
            return;
        }
        if (L == 6 ) {
            set.add(s);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 & nx < n && ny >= 0 && ny < n) {
                dfs(L + 1, nx, ny, s + board[nx][ny]);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ans = 0;
        board = new int[n][n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(0, i, j, "");
            }
        }
        System.out.println(set.size());


    }
}
