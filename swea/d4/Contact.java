package swea.d4;

import java.io.FileInputStream;
import java.util.*;

public class Contact {
    static int n, start;
    static int[][] graph;
    static int[] visit;

    static int bfs(int L) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(L);
        visit[L] = 1;
        int ans = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < 101; i++) {
                if (graph[temp][i] == 1 && visit[i] == 0) {
                    visit[i] = visit[temp] + 1;
                    queue.add(i);
                }
            }
            ans = Math.max(ans, visit[temp]);
        }
        for (int i = 100; i > 0; i--) {
            if (ans == visit[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            start = sc.nextInt();
            graph = new int[101][101];
            visit = new int[101];
            for (int i = 0; i < n / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph[from][to] = 1;
            }
            visit[start] = 1;
            int ans = bfs(start);

            System.out.println("#" + test_case + " " + ans);
        }
    }
}
