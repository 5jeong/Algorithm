package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 1 ~ m 숫자중 n개를 고른다.
 * 중복x, 고른숫자는 이전에 고른수보다 적어도 2배이상이어야한다.
 * 고를수 있는 모든 경우의 수 찾기.(DFS + 메모이제이션)
 */
public class Baekjoon_2758 {
    static long[][] map; // map[L][s] : L번째 숫자를 s로 선택한경우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            map = new long[n + 1][m + 1];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(map[i], -1);
            }
            System.out.println(dfs(n, m));
        }
    }

    static long dfs(int idx, int last) {
        if (last <= 0) {
            return 0;
        }
        if (idx == 1) {
            return last;
        }
        if (map[idx][last] == -1) {
            map[idx][last] = dfs(idx - 1, last / 2) + dfs(idx, last - 1);
        }
        return map[idx][last];
    }
}
