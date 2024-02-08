package Algorithm_Study_Inflearn.그래프;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 벽허물기 {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] cost = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[2] > cost[temp[0]][temp[1]]) {
                continue;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = temp[0] + dx[dir];
                int ny = temp[1] + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 0 && cost[nx][ny] > temp[2]) {
                    cost[nx][ny] = temp[2];
                    pq.offer(new int[]{nx, ny, cost[nx][ny]});
                }
                if (board[nx][ny] == 1 && cost[nx][ny] > temp[2] + 1) {
                    cost[nx][ny] = temp[2] + 1;
                    pq.offer(new int[]{nx, ny, cost[nx][ny]});
                }
            }
        }
        answer = cost[n - 1][m - 1];
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 1, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(solution(
                new int[][]{{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(solution(
                new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(solution(
                new int[][]{{0, 0, 1, 0, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1},
                        {1, 1, 0, 1, 1, 1, 0}}));
    }
}
