package Algorithm_Study_Inflearn.DFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class 가장가까운큰수 {

    static int[] arr;
    static int[] check;
    static int tanget,answer;
    static boolean flag;
    static void DFS(int L,int n){
        if(flag ==true){
            return ;
        }
        if(L==arr.length){
            if(n > tanget){
                answer = n;
                flag=true;
            }
        }
        else{
            for(int i=0;i<arr.length;i++){
                if(check[i]==0){
                    check[i]=1;
                    DFS(L+1,n*10+arr[i]);
                    check[i] =0;
                }
            }
        }
    }
    public static int solution(int n){
        answer = 0;
        String str = String.valueOf(n);
        int len = str.length();
        tanget=n;
        arr = new int[len];
        check = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = Character.getNumericValue(str.charAt(i));
        }
        Arrays.sort(arr);
        flag=false;
        DFS(0,0);
        if(answer==0){
            return -1;
        }
        else{
            return answer;
        }
    }

    public static void main(String[] args){
        System.out.println(solution(123));
        System.out.println(solution(321));
        System.out.println(solution(20573));
        System.out.println(solution(27711));
        System.out.println(solution(54312));
    }
}
