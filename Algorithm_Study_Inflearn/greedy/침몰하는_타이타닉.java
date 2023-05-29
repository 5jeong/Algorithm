package Algorithm_Study_Inflearn.greedy;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Arrays;
import java.util.Collections;

public class 침몰하는_타이타닉 {
    public static int solution(int[] nums, int m){
        int answer = 0;
        Arrays.sort(nums);
        int lt=0;
        int rt=nums.length-1;
        while(lt <= rt){
            if(nums[lt] + nums[rt] <=m){
                answer++;
                lt++;
                rt--;
            }
            else{
                answer++;
                rt--;
            }
        }



        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
