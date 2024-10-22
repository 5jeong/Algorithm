package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 *  n * m 크기의 직사각형 방,  0 이면 청소해야댐, 1이면 청소한곳
 * d가 0=북쪽, 1=동쪽, 2=남쪽, 3=서쪽
 * 현재칸 주변 4칸중 0이 없는경우( 모두 1인경우) -> 바라보는 방향으로 후진 -> 후진못하면 종료
 * 회전은 반시계방향으로 회전!
 */
public class Baekjoon_14503 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int time;
    static int n, m;
    static int[][] board;

    static void dfs(int x, int y, int d) {
        board[x][y] = -1;
        // 4방향 반시계 방향으로 탐색
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                time++;
                dfs(nx, ny, d);
                return;
            }
        }

        // 주변 4칸중 0이 없는 경우 d방향으로 후진
        int dir = (d + 2) % 4;
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) {
            dfs(nx, ny, d); // 바라보는 방향은 유지
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = 1;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(x, y, d);
        System.out.println(time);
    }
}
