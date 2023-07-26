package Algorithm_Study_Inflearn.greedy;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Arrays;

public class 이동횟수 {
    public static int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);
        int lt = 0;
        int rt = nums.length-1;
        while(lt <=rt){
            if(nums[lt] + nums[rt] <= 5){
                lt++;
                rt--;
                answer++;
            }
            else{
                answer++;
                rt--;
            }
        }
//        int temp=0;
//        while(lt <=rt){
//            temp = nums[lt] + nums[rt];
//            while(temp <= 5){
//               lt++;
//               temp += nums[lt];
//           }
//           rt--;
//           answer++;
//        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(solution(new int[]{2, 3, 4, 5}));
        System.out.println(solution(new int[]{3, 3, 3, 3, 3}));
    }
}
