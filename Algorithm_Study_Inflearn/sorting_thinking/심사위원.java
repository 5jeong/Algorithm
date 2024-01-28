package Algorithm_Study_Inflearn.sorting_thinking;

import java.util.ArrayList;
import java.util.Arrays;

public class 심사위원 {
    public static int solution(int[] score, int k) {
        int answer = 0;
        int n = score.length;
        Arrays.sort(score);
        int s = 0, e = 0;
        for (int i = 0; i < n; i++) {
            if (score[i + k - 1] - score[i] <= 10) {
                s = i;
                e = i + k - 1;
                break;
            }
        }
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += score[i];
        }
        answer = sum / k;
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
