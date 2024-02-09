package Algorithm_Study_Inflearn.그래프;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 방향바꾸기 {
    public static int solution(int[][] board) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = board.length;
        int m = board[0].length;
        int[][] ch = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (cost[temp[0]][temp[1]] < temp[2]) {
                continue;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = temp[0] + dx[dir];
                int ny = temp[1] + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[temp[0]][temp[1]] - 1 == dir && cost[nx][ny] > temp[2]) {
                    cost[nx][ny] = cost[temp[0]][temp[1]];
                    pq.offer(new int[]{nx, ny, cost[nx][ny]});
                } else if (cost[nx][ny] > temp[2] + 1) {
                    cost[nx][ny] = temp[2] + 1;
                    pq.offer(new int[]{nx, ny, cost[nx][ny]});
                }
            }
        }
        answer = cost[n - 1][m - 1];
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(solution(
                new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4},
                        {1, 2, 2, 3, 3, 4}}));
        System.out.println(solution(
                new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4},
                        {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1},
                {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4},
                {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
