package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.ArrayList;

public class 최대길이바이토닉수열 {
    public static int solution(int[] nums){
        int answer = 0;
        ArrayList<Integer> peak = new ArrayList<>();
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peak.add(i);
            }
        }
        for(int x : peak){
            int left = x;
            int right = x;
            int len=1;
            while(left-1 >= 0 && nums[left] > nums[left-1] ){
                left--;
                len++;
            }
            while(right+1 <= nums.length-1 && nums[right] > nums[right+1]){
                right++;
                len++;
            }
            answer = Math.max(answer,len);
        }
        System.out.println();

        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5 ,1}));
        System.out.println(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));

    }
}
