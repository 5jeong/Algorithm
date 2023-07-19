package Algorithm_Study_Inflearn.sorting_thinking;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Arrays;

public class 이진수정렬 {
    public static int[] solution(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];

        int[][] res = new int[n][2];
        for(int i=0;i<n;i++){
            int cnt=0;
            String binary = Integer.toBinaryString(nums[i]);
            for(char x : binary.toCharArray()){
                if(x=='1'){
                    cnt++;
                }
            }
            res[i][0] = nums[i];
            res[i][1] = cnt;
        }
        Arrays.sort(res,(a,b)-> a[1]==b[1] ? a[0] - b[0] : a[1] -b[1] ); // 오름차순일땐 a[] - b[] 내림차순일떈 b[] - a[]
        for(int i=0;i<n;i++){
            answer[i] = res[i][0];
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

}
