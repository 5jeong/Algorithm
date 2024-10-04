package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;

public class 바둑대회 {

    static int n, ans;
    static int[] ch;

    static void dfs(int L, int s, int[][] cans) {
        if (L == n / 2) {
            int whiteSum = 0;
            int blackSum = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    whiteSum += cans[i][0];
                } else {
                    blackSum += cans[i][1];
                }
            }
            ans = Math.min(ans, Math.abs(whiteSum - blackSum));

        } else {
            // 조합
            for (int i = s; i < n; i++) {
                ch[i] = 0;
                dfs(L + 1, i + 1, cans);
                ch[i] = 1;
            }
        }
    }

    public static int solution(int[][] cans) {
        n = cans.length;
        ans = Integer.MAX_VALUE;
        ch = new int[n];
        dfs(0, 0, cans);
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(
                solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}
