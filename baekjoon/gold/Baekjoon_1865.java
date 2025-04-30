package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 웜홀 -> 벨반포드 알고리즘
public class Baekjoon_1865 {
    static List<List<Node>> graph;
    static int[] dist;
    static int n, m, w;
    static StringBuilder sb;

    static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sb = new StringBuilder();
        while (test-- > 0) {
            n = sc.nextInt(); // 지점 수
            m = sc.nextInt(); // 도로 수
            w = sc.nextInt(); // 웜홀 수

            graph = new ArrayList<>();
            dist = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();
                graph.get(s).add(new Node(e, t));
                graph.get(e).add(new Node(s, t));
            }

            // 웜홀 추가
            for (int i = 0; i < w; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();
                graph.get(s).add(new Node(e, -t));
            }

            for (int i = 1; i <= n; i++) {
                graph.get(0).add(new Node(i, 0));
            }
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;

            if (bellmanFord()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }


    // 벨만포드 알고리즘
    private static boolean bellmanFord() {

        for (int i = 1; i <= n; i++) {
            for (int from = 0; from <= n; from++) {
                if (dist[from] == Integer.MAX_VALUE) {
                    continue;
                }
                for (Node next : graph.get(from)) {
                    if (dist[next.to] > dist[from] + next.cost) {
                        dist[next.to] = dist[from] + next.cost;
                    }
                }
            }
        }

        // 음수 사이클 판별
        for (int from = 0; from <= n; from++) {
            if (dist[from] == Integer.MAX_VALUE) {
                continue;
            }
            for (Node next : graph.get(from)) {
                if (dist[next.to] > dist[from] + next.cost) {
                    // start가 포함된 음수 사이클인지 확인
                    return true;
                }
            }
        }
        return false;
    }
}

