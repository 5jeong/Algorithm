package baekjoon.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_1707 {
    static int v, e;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        while (k-- > 0) {
            v = sc.nextInt(); // 정점 개수
            e = sc.nextInt(); // 간선 개수

            graph = new ArrayList<>();
            colors = new int[v + 1];
            flag = true;
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
                colors[i] = 0 ;
            }
            for (int i = 0; i < e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int j = 1; j <= v; j++) {
                if (!flag) {
                    break;
                }
                if(colors[j]==0){
                    dfs(j, 1);
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }

    static void dfs(int s, int color) {
        colors[s] = color;
        for (int x : graph.get(s)) {
            // 현재와 이전 정점의 색이 같으면 false
            if (color == colors[x]) {
                flag = false;
                return;
            }
            // 방문 안했을때
            if (colors[x] == 0) {
                dfs(x, -color);
            }
        }
    }
}
