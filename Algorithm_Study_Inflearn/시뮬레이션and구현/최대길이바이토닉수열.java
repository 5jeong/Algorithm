package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.ArrayList;

public class 최대길이바이토닉수열 {
    public static int solution(int[] nums){
        int answer = 0;
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peaks.add(i);
            }
        }
        for (int x : peaks) {
            int lt = x - 1;
            int rt = x + 1;
            int cnt = 1;
            while (lt >= 0 && nums[lt] < nums[lt + 1]) {
                lt--;
                cnt++;
            }
            while (rt < nums.length && nums[rt] < nums[rt - 1]) {
                rt++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5 ,1}));
        System.out.println(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));

    }
}
