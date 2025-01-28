package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***
 * 소문난 칠공주
 * 25명 학생중 7명 뽑음 (조합)
 * s 포함 개수와 연결여부를 통해 확인(bfs)
 * s가 최소 4개이상 있어야하며, 모두 연결되어야 함.
 */
public class Baekjoon_1941 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static int[][] ch;
    static int ans;
    static int[] pick;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new char[5][5];
        ans = 0;
        ch = new int[5][5];
        pick = new int[7];
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        combi(0, 0, 0);
        System.out.println(ans);

    }

    // 25명중 7명 뽑기
    static void combi(int L, int s, int yCnt) {
        // 임도연파가 4명이상이면 백
        if (yCnt >= 4) {
            return;
        }
        if (L == 7) {
            ch = new int[5][5];
            bfs(pick[0] / 5, pick[0] % 5);
        } else {
            for (int i = s; i < 25; i++) {
                pick[L] = i;
                combi(L + 1, i + 1, board[i / 5][i % 5] == 'Y' ? yCnt + 1 : yCnt);
            }
        }
    }

    // 연결되어있는지 확인
    static void bfs(int x, int y) {
        int cnt = 1;
        ch[x][y] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(pick[0]);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int a = temp / 5;
            int b = temp % 5;
            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                int target = nx * 5 + ny;
                // 방문한적 없고, 인접하면 queue에 넣기
                for (int j = 0; j < 7; j++) {
                    if (ch[nx][ny] == 0 && pick[j] == target) {
                        cnt++;
                        ch[nx][ny] = 1;
                        queue.offer(target);
                    }
                }
            }
        }
        if (cnt == 7) {
            ans++;
        }
    }


}
