package Algorithm_Study_Inflearn.자료구조활용;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 현관문_출입순서 {
    public static int[] solution(int[] arrival, int[] state){
        int n = arrival.length;
        int[] answer = new int[n];
        int prev = 1; // 1일때는 1초전에 나가는경우 0일때는 1초전에 들어온경우
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int cnt=0;
        for(int t=0,i=0;;t++){
            if(enter.isEmpty() && exit.isEmpty() && i < n){
                if(t < arrival[i]){
                    t = arrival[i];
                    prev = 1;
                }
            }
            while(i<n && arrival[i]<=t){
                if(state[i]==1){
                    exit.add(i);
                }
                else{
                    enter.add(i);
                }
                i++;
            }
            if(prev==1){
                if(!exit.isEmpty()){
                    answer[exit.poll()]=t;
                }
                else{
                    answer[enter.poll()] =t;
                    prev=0;
                }
            }
            else if(prev==0){
                if(!enter.isEmpty()){
                    answer[enter.poll()] = t;
                }
                else{
                    answer[exit.poll()]=t;
                    prev=1;
                }
            }
            cnt++;
            if(cnt ==n){
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
