package Algorithm_Study_Inflearn.그래프;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 공굴리기 {
    public static int solution(int[][] board, int[] s, int[] e) {
        int answer = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{s[0], s[1], 0});
        cost[s[0]][s[1]] = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[2] > cost[temp[0]][temp[1]]) {
                continue;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = temp[0];
                int ny = temp[1];
                int len = temp[2];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    len++;
                    nx += dx[dir];
                    ny += dy[dir];
                }
                nx -= dx[dir];
                ny -= dy[dir];
                len--;
                if (cost[nx][ny] > len) {
                    cost[nx][ny] = len;
                    pq.offer(new int[]{nx, ny, len});
                }
            }
        }
        if (cost[e[0]][e[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        answer = cost[e[0]][e[1]];
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(solution(
                new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(solution(
                new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}},
                new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(solution(
                new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(solution(
                new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
