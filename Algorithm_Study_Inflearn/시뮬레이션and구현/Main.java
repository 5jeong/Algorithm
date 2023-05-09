package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.Arrays;

import java.util.*;
class Solution {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        for(int i=0;i<n;i++){
            answer[i] = (char)(i+65);
        }
        for(int s=1;s<=5;s++){

        }
        for(int i=0;i<ladder.length;i++){
            for(int j =0;j<ladder[0].length;j++){
                System.out.print(ladder[i][j]+" ");
            }
            System.out.println();
        }
        return answer;
    }
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
//        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
//        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
//        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
