package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 합이같은부분집합_DFS {
    private static String ans = "NO";
    private static boolean flag = false;
    private static int total, n;

    private static void dfs(int L, int sum, int[] arr) {
        if (flag || sum > total / 2) {
            return;
        }
        if (L == n) {
            if (total == sum * 2) {
                ans = "YES";
                flag = true;
            }
        } else {
            dfs(L + 1, sum + arr[L], arr);
            dfs(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        dfs(0, 0, arr);
        System.out.println(ans);

    }
}
