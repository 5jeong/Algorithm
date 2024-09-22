package algorithmStudy.DFS_BFS활용;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환_DFS {

    static int n, ans = Integer.MAX_VALUE;
    static Integer[] coin;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.sort(coin, Collections.reverseOrder());
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int L, int sum) {
        if (sum > m || L > ans) {
            return;
        }
        if (sum == m) {
            ans = Math.min(ans, L);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(L + 1, sum + coin[i]);
            }
        }
    }
}
