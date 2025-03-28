package baekjoon.gold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 줄세우기(위상정렬)
public class Baekjoon_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점 개수
        int m = sc.nextInt(); // 간선 개수
        int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b]++; // 차수증가
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ans.append(now).append(" ");
            for (int next : graph.get(now)) {
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        System.out.println(ans);

    }
}