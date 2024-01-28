package Algorithm_Study_Inflearn.sorting_thinking;

import java.util.Arrays;

public class 멀티태스킹 {
    public static int solution(int[] tasks, long k) {
        int answer = 0;
        int n = tasks.length;
        int[] temp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            temp[i + 1] = tasks[i];
        }
        int rest = n;
        Arrays.sort(temp);
        for (int i = 1; i < temp.length; i++) {
            long time = (temp[i] - temp[i - 1]) * rest;
            if (time <= k) {
                k -= time;
                rest--;
            } else {
                k = k % rest;
                if (k == 0) {
                    return i;
                }
                int idx = 0;
                while (k > 0) {
                    if (temp[i] <= tasks[idx]) {
                        k--;
                    }
                    idx++;
                }
                return idx + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, 5));
        System.out.println(solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
