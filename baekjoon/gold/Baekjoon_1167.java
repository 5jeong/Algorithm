package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 트리의 지름
 * 정점이 순서대로 주어진다는 보장이 없음
 * dfs 1번은 완전탐색은 시간초과
 * dfs 2번으로 해결
 * 1. 임의의 정점에서 가장 먼 정점을 찾음. (dfs)
 * 2. 이 정점에서 가장 먼 정점까지의 거리가 트리의 지름. (dfs)
 */
public class Baekjoon_1167 {
    static int v, maxLen, maxNode;
    static int[] visited;
    static ArrayList<ArrayList<Info>> graph;

    static class Info {
        int node;
        int len;

        Info(int node, int len) {
            this.node = node;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        maxLen = Integer.MIN_VALUE;
        maxNode = 0;
        graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                int b = Integer.parseInt(st.nextToken());
                graph.get(num).add(new Info(a, b));
            }
        }
        // 1. 임의의 정점에서 가장 먼 정점 찾기
        visited = new int[v + 1];
        maxLen = 0;
        dfs(1, 0);

        //  2. 찾은 정점에서 가장 먼 정점까지 거리 구하기
        visited = new int[v + 1];
        maxLen = 0;
        dfs(maxNode, 0);

        System.out.println(maxLen);
    }

    static void dfs(int s, int sum) {
        visited[s] = 1;
        if (maxLen < sum) {
            maxLen = sum;
            maxNode = s;
        }
        for (Info info : graph.get(s)) {
            if (visited[info.node] == 0) {
                dfs(info.node, sum + info.len);
            }
        }
    }
}
