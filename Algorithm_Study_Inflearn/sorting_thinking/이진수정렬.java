package Algorithm_Study_Inflearn.sorting_thinking;

import java.util.Arrays;

public class 이진수정렬 {
    public static int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        int n = nums.length;
        int[][] res = new int[n][2];

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            String temp = Integer.toBinaryString(nums[i]);
            for (char x : temp.toCharArray()) {
                if (x == '1') {
                    cnt++;
                }
            }
            res[i][0] = nums[i];
            res[i][1] = cnt;
        }
        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            answer[i] = res[i][0];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

}
