package Algorithm_Study_Inflearn.sorting_thinking;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Arrays;

public class 멀티태스킹 {
    public static int solution(int[] tasks, long k) {
        int answer = 0;
        int rest = tasks.length;
        int[] st = new int[rest+1];
        st[0] = 0;
        for(int i=0;i<rest;i++){
            st[i+1] = tasks[i];
        }
        Arrays.sort(st);
        int n = 0;
        for(int i=1;i<st.length;i++){
            int temp = (st[i] - st[i-1]) * rest;
            if(temp > k){
                n = st[i];
                break;
            }
            k-=temp;
            rest--;
        }
        k = k % rest;
        int idx=0;
        for(int i=0;i<tasks.length;i++){
            if(tasks[i] < n) continue;
            idx++;
            if(idx >k){
                answer=i+1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 2, 3}, 5));
        System.out.println(solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
