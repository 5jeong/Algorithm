package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1987 {
    static int r, c;
    static int[][] board;
    static boolean[] alp; // 알파벳 체크
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    static int ans;

    static void dfs(int x, int y, int L) {
        if (alp[board[x][y]]) {
            ans = Math.max(ans, L);
        } else {
            alp[board[x][y]] = true;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    dfs(nx, ny, L + 1);
                }
            }
            alp[board[x][y]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        visited = new int[r][c];
        ans = 1;
        alp = new boolean[26];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 0);

        System.out.println(ans);
    }
}
