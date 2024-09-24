package algorithmStudy.DFS_BFS활용;

import algorithmStudy.DFS_BFS활용.Main.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 피자배달거리_DFS {
    private static int n, m;
    private static List<Main.Point> homes, pizzas;
    private static int[] combi;
    private static int ans = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void dfs(int L, int s) {
        if (L == m) {
            int city_dis = 0;

            for (Main.Point home : homes) {
                int home_dis = Integer.MAX_VALUE;
                for (int x : combi) {
                    home_dis = Math.min(home_dis,
                            Math.abs(pizzas.get(x).x - home.x) + Math.abs(pizzas.get(x).y - home.y));
                }
                city_dis += home_dis;
            }

            ans = Math.min(ans, city_dis);
        } else {
            for (int i = s; i < pizzas.size(); i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];
        homes = new ArrayList<>();
        pizzas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    homes.add(new Main.Point(i, j));
                }
                if (temp == 2) {
                    pizzas.add(new Main.Point(i, j));
                }
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }
}
