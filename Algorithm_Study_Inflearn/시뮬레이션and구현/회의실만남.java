package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.Arrays;

public class 회의실만남 {
    public static int[] solution(int[] enter, int[] exit){
        int n =enter.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            enter[i]--;
            exit[i]--;
        }
        int[] enterIdx = new int[n];
        int[] enterT = new int[n];
        int[] exitT=new int[n];
        for(int i=0;i<n;i++){
            enterIdx[enter[i]] = i;
        }
        int cnt=0;
        for(int i=0,j=0;i<n;i++){
            while(j<n && j <= enterIdx[exit[i]]){
                enterT[enter[j]]=cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!(exitT[i] < enterT[j] || exitT[j] < enterT[i]) ){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
