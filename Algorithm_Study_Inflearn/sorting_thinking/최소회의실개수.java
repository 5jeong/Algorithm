package Algorithm_Study_Inflearn.sorting_thinking;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 최소회의실개수 {
    public static int solution(int[][] meetings){
        int answer = 0;
        int n = meetings[0].length;
        Arrays.sort(meetings,(a,b)->a[0] - b[0]);
        ArrayList<int[]> time = new ArrayList<>();
        for(int[] x : meetings){
            time.add(new int[]{x[0],1});
            time.add(new int[]{x[1],2});
        }
        Collections.sort(time,(a,b)->a[0]==b[0]? b[1]-a[1] : a[0] - b[0]);
        int cnt=0;
        for(int[] x : time){
            if(x[1]==1){
                cnt++;
            }
            else{
                cnt--;
            }
            answer= Math.max(answer,cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
