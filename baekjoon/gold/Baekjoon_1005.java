package baekjoon.gold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ACM Craft
public class Baekjoon_1005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] time = new int[n + 1];        // 각 건물 건설 시간
            int[] indegree = new int[n + 1];    // 진입 차수
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<Integer>());
            }

            for (int i = 1; i <= n; i++) {
                time[i] = sc.nextInt();
            }
            for (int i = 1; i <= k; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                graph.get(start).add(end);
                indegree[end]++;
            }
            int goal = sc.nextInt(); // 목표건물 번호

            Queue<Integer> queue = new LinkedList<>();
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = time[i];
                }
            }
            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (Integer next : graph.get(now)) {
                    indegree[next]--;
                    dp[next] = Math.max(dp[next], dp[now] + time[next]);
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            ans.append(dp[goal]).append("\n");
        }
        System.out.println(ans);
    }
}
