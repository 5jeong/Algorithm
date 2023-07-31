package Algorithm_Study_Inflearn.DFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.Stack;

public class 바둑대회 {
    static int answer,n;
    static int[] ch;
    static void DFS(int L,int s,int[][] cans){
        if(L==n){
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            for(int i=0;i<cans.length;i++){
                if(ch[i]==1){
                    a.add(i);
                }
                else{
                    b.add(i);
                }
            }
            int sum1 = 0,sum2=0;
            for(int i=0;i<n;i++){
                sum1+=cans[a.get(i)][0];
                sum2+=cans[b.get(i)][1];
            }
            answer = Math.min(answer,Math.abs(sum1-sum2));
        }
        else{
            for(int i=s ; i< cans.length;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    DFS(L+1,i+1,cans);
                    ch[i]=0;
                }
            }
        }
    }
    public static int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        ch = new int[cans.length];
        n = cans.length / 2;
        DFS(0,0,cans);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
