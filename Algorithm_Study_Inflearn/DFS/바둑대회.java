package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;

public class 바둑대회 {
    static int answer, n;
    static int[] ch;

    static void dfs(int L, int s, int[][] cans) {
        if (L == n / 2) {
            ArrayList<Integer> white = new ArrayList<>();
            ArrayList<Integer> black = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    white.add(i);
                } else {
                    black.add(i);
                }
            }
            int white_sum = 0;
            int black_sum = 0;
            for (int i = 0; i < n / 2; i++) {
                white_sum += cans[white.get(i)][0];
                black_sum += cans[black.get(i)][1];
            }
            answer = Math.min(answer, Math.abs(white_sum - black_sum));
        } else {
            for (int i = s; i < n; i++) {
                ch[i] = 1;
                dfs(L + 1, i + 1, cans);
                ch[i] = 0;
            }
        }
    }

    public static int solution(int[][] cans) {
        answer = Integer.MAX_VALUE;
        n = cans.length;
        ch = new int[n];
        dfs(0, 0, cans);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(
                solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}
