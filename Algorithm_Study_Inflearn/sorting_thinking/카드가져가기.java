package Algorithm_Study_Inflearn.sorting_thinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class 카드가져가기 {
    public static int solution(int[] nums, int k) {
        int answer = 0;
        int n = nums.length;
        Arrays.sort(nums);
        Integer[] temp = new Integer[n / 2];
        int score = 0;
        int idx = 0;
        for (int i = 0; i < n; i += 2) {
            score += nums[i];
            temp[idx] = nums[i + 1] - nums[i];
            idx++;
        }
        Arrays.sort(temp, (a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            score += temp[i];
        }
        answer = score;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(
                solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
