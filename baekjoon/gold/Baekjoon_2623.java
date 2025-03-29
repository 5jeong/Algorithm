package baekjoon.gold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//음악 프로그램
public class Baekjoon_2623 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            List<Integer> singers = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                singers.add(sc.nextInt());
            }
            for (int s = 0; s < singers.size() - 1; s++) {
                int start = singers.get(s);
                int end = singers.get(s + 1);
                graph.get(start).add(end);
                indegree[end]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ans.append(now).append("\n");
            cnt++;

            for (int next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        System.out.println(cnt == n ? ans : 0);
    }
}
