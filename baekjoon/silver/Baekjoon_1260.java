package baekjoon.silver;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1260 {
    static int n, m, v;
    static int[][] board;
    static int[] visit;

    static void dfs(int v) {
        System.out.print(v+" ");
        for (int i = 1; i <= n; i++) {
            if (board[v][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                dfs(i);
            }
        }
    }

    static void bfs() {
        visit = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for (int i = 1; i <= n; i++) {
                if (board[temp][i] == 1 && visit[i] == 0) {
                    visit[i] = 1;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        board = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a][b] = 1;
            board[b][a] = 1;
        }
        visit = new int[n + 1];
        visit[v] = 1;
        dfs(v);
        System.out.println();
        bfs();

    }
}
