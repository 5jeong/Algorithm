package baekjoon.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 트리의지름
public class Baekjoon_1967 {
    static List<List<Node>> graph;
    static int maxSum, maxIdx;
    static int[] visited;

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        visited = new int[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        maxSum = 0;
        maxIdx = 1;
        dfs(1, 0);
        maxSum = 0;
        visited = new int[n+1];
        dfs(maxIdx, 0);
        System.out.println(maxSum);

    }

    static void dfs(int start, int sum) {
        visited[start] = 1;
        if (maxSum < sum) {
            maxSum = sum;
            maxIdx = start;
        }
        for (Node next : graph.get(start)) {
            if (visited[next.idx] == 0) {
                dfs(next.idx, sum + next.cost);
            }
        }
    }
}
