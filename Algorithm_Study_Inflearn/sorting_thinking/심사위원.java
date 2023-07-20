package Algorithm_Study_Inflearn.sorting_thinking;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class 심사위원 {
    public static int solution(int[] score, int k){
        int answer = 0;
        int n = score.length;
        Arrays.sort(score);
        int idx=0;
        ArrayList<Integer> res = new ArrayList<>();

//        for(int x : score){
//            System.out.print(x+" ");
//        }
//        System.out.println();
        for(int i=0;i<= n-k;i++){
            if(score[i+k-1] - score[i] <= 10){
                for(int j = i; j <i+k;j++){
                    res.add(score[j]);
                }
                break;
            }
        }
        for(int x : res){
            answer+=x;
        }
        answer = answer/k;

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
