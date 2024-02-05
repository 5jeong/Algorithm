package Algorithm_Study_Inflearn.그래프;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 최소환승경로 {
    public static int solution(int[][] routes, int s, int e) {
        int answer = 0;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int n = routes.length;
        int cnt = 0;
        for (int[] x : routes) {
            for (int y : x) {
                graph.putIfAbsent(y, new ArrayList<>() {
                });
                graph.get(y).add(cnt);
            }
            cnt++;
        }
        int[] ch = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        int L = 0;
        queue.add(s);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int temp = queue.poll();
                for (int x : graph.get(temp)) {
                    if (ch[x] == 1) {
                        continue;
                    }
                    ch[x] = 1;
                    for (int y : routes[x]) {
                        if (y == e) {
                            return L;
                        }
                        queue.offer(y);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15},
                        {14, 12, 16, 17}}, 1, 12));
        System.out.println(
                solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(solution(new int[][]{{7, 12}, {5, 19}, {7, 19}, {9, 12, 13}, {9, 5, 15}}, 9, 19));
        System.out.println(solution(new int[][]{{1, 2, 3, 4, 5}, {9, 7, 10}, {7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
