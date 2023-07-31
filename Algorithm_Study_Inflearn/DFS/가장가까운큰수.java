package Algorithm_Study_Inflearn.DFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class 가장가까운큰수 {

    static ArrayList<Integer> nums;
    static int[] check;
    static int tanget,answer;
    static boolean flag;
    static void DFS(int L,int n){
        if(flag){
            return;
        }
        if(L== nums.size()){
            if(tanget < n){
                answer = n;
                flag=true;
            }
        }
        else{
            for(int i=0;i< nums.size();i++){
                if(check[i]==0){
                    check[i]=1;
                    DFS(L+1,n*10+nums.get(i));
                    check[i] =0;
                }
            }

        }
    }
    public static int solution(int n){
        answer = 0;
        tanget = n;
        flag = false;
        nums = new ArrayList<>();
        int tmp= n;
        while(tmp >0){
            int t = tmp %10;
            nums.add(t);
            tmp /= 10;
        }
        check = new int[nums.size()];
        nums.sort((a,b)-> a-b);
        DFS(0,0);
        if(flag ==false){
            return -1;
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(123));
        System.out.println(solution(321));
        System.out.println(solution(20573));
        System.out.println(solution(27711));
        System.out.println(solution(54312));
    }
}
