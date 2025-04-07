package Promgrammers.level3;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {
    static boolean[] ch;
    static List<List<Integer>> graph;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new boolean[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);

                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    private void dfs(int start) {
        ch[start] = true;
        for (int x : graph.get(start)) {
            if (!ch[x]) {
                dfs(x);
            }
        }
    }
}
