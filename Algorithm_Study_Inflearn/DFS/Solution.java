package Algorithm_Study_Inflearn.DFS;

import java.util.*;

class Solution {
    static int ans, n;
    static int[] ch;
    static ArrayList<Integer> white, black;

    private void dfs(int L, int s) {
        if (L == n / 2) {
            int whiteSum = 0;
            int blackSum = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    whiteSum += white.get(i);
                } else {
                    blackSum += black.get(i);
                }
            }

            ans = Math.min(ans, Math.abs(whiteSum - blackSum));
        } else {
            for (int i = s; i < n; i++) {
                ch[i] = 1;
                dfs(L + 1, i + 1);
                ch[i] = 0;
            }
        }
    }

    public int solution(int[][] cans) {
        int answer = 0;
        n = cans.length;
        white = new ArrayList<>();
        black = new ArrayList<>();
        ch = new int[n];
        ans = Integer.MAX_VALUE;
        for (int[] x : cans) {
            white.add(x[0]);
            black.add(x[1]);
        }
        dfs(0, 0);
        return ans;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(
                new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}