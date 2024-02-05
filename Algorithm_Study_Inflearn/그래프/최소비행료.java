package Algorithm_Study_Inflearn.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 최소비행료 {
    public static int solution(int n, int[][] flights, int s, int e, int k) {
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        queue.offer(new int[]{s, 0});
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for (int i = 0; i < len; i++) {
                int[] temp = queue.poll();
                int now = temp[0];
                int nowCost = temp[1];
                for (int[] x : graph.get(now)) {
                    int next = x[0];
                    int nextCost = nowCost + x[1];
                    if (nextCost < cost[next]) {
                        cost[x[0]] = nextCost;
                        queue.offer(new int[]{next, nextCost});
                    }
                }
            }
            if (L > k) {
                break;
            }
        }
        answer = cost[e];
        if (cost[e] == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5,
                new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30},
                        {3, 4, 10}}, 0, 3, 1));
        System.out.println(solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(solution(8,
                new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10},
                        {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(solution(10,
                new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100},
                        {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }
}
