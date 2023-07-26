package Algorithm_Study_Inflearn.greedy;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;

public class 스프링쿨러 {
    public static int solution(int n, int[] nums){
        int answer = 0;
        ArrayList<int[]> line = new ArrayList<>();
        for(int i=0;i<=n;i++){
            int a = i-nums[i];
            int b = i+nums[i];
            if(a<0) a=0;
            if(b >=n) b=n;
            if(nums[i]==0){
                a=0;
                b=0;
            }
            line.add(new int[]{a,b});
        }
        line.sort((a,b)-> a[0]!=b[0] ? a[0] - b[0] : a[1] -b[1]);
        int l = line.size();
        int s=0,e=0;
        for(int i=0;i<l;i++){
            if(s >= line.get(i)[0]){
                e = line.get(i)[1];
            }
            else{
                if( e < line.get(i)[0]){
                    return -1;
                }
                answer++;
                s = e;
                e = line.get(i)[1];
            }
            if(e == n){
                answer++;
                break;
            }
//            System.out.println("s : " +s + "     e : " + e);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
