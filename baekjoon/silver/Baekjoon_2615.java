package baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * 오목
 * 19 * 19 크기 바둑판에서 누가 이긴지 판단 ( 6목은 승리x)
 * 승부가 결정안나면 0, 검은색이 이기면 1, 흰색이 이기면 2 출력
 * 승리한 색의 가장 왼쪽 좌표 출력 ( +1씩 해서 출력)
 */
public class Baekjoon_2615 {
    static int[][] board = new int[19][19];
    // dx, dy 배열: 8방향 (단, 4방향 탐색 시 한 방향과 반대 방향만 사용)
    static int[] dx = {0, 1, -1, 1, -1, 1, -1, 0};
    static int[] dy = {1, 0, 1, 1, -1, -1, 0, -1};
    static ArrayList<int[]> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 바둑판 입력
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 바둑판 좌상단부터 순회하며 돌이 있는 경우 탐색
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (board[i][j] != 0) {
                    res = new ArrayList<>();
                    if (find(i, j, board[i][j])) {
                        System.out.println(board[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    // 해당 좌표에서 시작하여 4가지 방향(가로, 세로, 두 대각선)으로 연속된 돌 탐색
    static boolean find(int x, int y, int color) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x, ny = y;
            int cnt = 1; // 시작 돌 포함

            // 한 방향 탐색
            while (true) {
                nx += dx[dir];
                ny += dy[dir];
                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != color) {
                    break;
                }
                res.add(new int[]{nx, ny});
                cnt++;
            }

            nx = x;
            ny = y;
            // 반대 방향 탐색 (dx, dy의 반대 방향: 인덱스 7 - dir)
            while (true) {
                nx += dx[7 - dir];
                ny += dy[7 - dir];
                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != color) {
                    break;
                }
                res.add(new int[]{nx, ny});
                cnt++;
            }

            if (cnt == 5) { // 정확히 5개 연속이면 승리
                return true;
            }
        }
        return false;
    }
}
