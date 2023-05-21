package Algorithm_Study_Inflearn.자료구조활용;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.HashSet;

public class 최대길이_연속수열 {
    public static int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int x : nums){
            hashSet.add(x);
        }
        for(int x : hashSet){
            int len=0;
            if(hashSet.contains(x-1)){
                continue;
            }
            while(hashSet.contains(x)){
                x++;
                len++;
            }

            answer= Math.max(answer,len);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
