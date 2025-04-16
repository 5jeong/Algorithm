package baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 트리의 부모찾기
public class Baekjoon_11725 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        find(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void find(int n) {
        visited[n] = true;
        for (int x : graph.get(n)) {
            if (!visited[x]) {
                parent[x] = n;
                find(x);
            }
        }
    }
}
