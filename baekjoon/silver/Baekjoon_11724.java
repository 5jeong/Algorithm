package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/***
 * 연결 요소의 개수
 * dfs 또는 bfs를 진행하여 연결요소의 개수를 증가
 */
public class Baekjoon_11724 {
    static int[][] graph;
    static int[] visited;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 정점 개수
        m = sc.nextInt(); // 간선 개수

        graph = new int[n + 1][n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs2(i);
//                bfs(i);
                ans++;
            }
        }
        System.out.println(ans);

    }

    // dfs(재귀)
    static void dfs(int s) {
        visited[s] = 1;
        for (int i = 1; i <= n; i++) {
            if (graph[s][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }

    // dfs(스택)
    static void dfs2(int s){
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        visited[s] = 1;

        while(!stack.isEmpty()){
            int now = stack.pop();
            for (int i = 1; i <= n; i++) {
                if(graph[now][i]==1 && visited[i]==0){
                    stack.push(i);
                    visited[i] = 1;
                }
            }
        }
    }

    // bfs
    static void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for (int i = 1; i <= n; i++) {
                if(graph[now][i]==1 && visited[i]==0){
                    queue.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }

}
