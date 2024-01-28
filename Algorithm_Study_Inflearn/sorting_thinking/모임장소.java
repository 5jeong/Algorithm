package Algorithm_Study_Inflearn.sorting_thinking;

import java.util.ArrayList;
import java.util.Collections;

public class 모임장소 {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    x.add(i);
                    y.add(j);
                }
            }
        }
//        Collections.sort(x);
        Collections.sort(y);
        int nx = x.get(cnt / 2);
        int ny = y.get(cnt / 2);
        for (int i = 0; i < cnt; i++) {
            answer += Math.abs(nx - x.get(i));
            answer += Math.abs(ny - y.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(solution(
                new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(solution(
                new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
