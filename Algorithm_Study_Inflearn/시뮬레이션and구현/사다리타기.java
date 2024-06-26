package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.Arrays;

public class 사다리타기 {
    public static char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (i + 65);
        }
        for (int[] x : ladder) {
            for (int idx : x) {
                char temp = answer[idx - 1];
                answer[idx - 1] = answer[idx];
                answer[idx] = temp;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
