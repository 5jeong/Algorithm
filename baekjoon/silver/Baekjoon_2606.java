package baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_2606 {
    static int n, m, ans;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visisted;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 컴퓨터수
        m = sc.nextInt(); // 컴퓨터 쌍수
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visisted = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ans = 0;
        dfs(1);
        System.out.println(ans);
    }

    static void dfs(int s) {
        visisted[s] = 1;
        for (int x : graph.get(s)) {
            if (visisted[x] == 0) {
                ans++;
                dfs(x);
            }
        }
    }
}
