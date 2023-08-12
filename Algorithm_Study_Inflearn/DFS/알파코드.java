package Algorithm_Study_Inflearn.DFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import javax.print.DocFlavor;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;

public class 알파코드 {
    static int[] dy;

    static int DFS(int L,String s){
        if(dy[L] > 0) return dy[L];
        if(L < s.length() && s.charAt(L)=='0') return 0;
        if(L== s.length() || L == s.length()-1) return 1;

        else{
            int res = DFS(L+1,s);
            System.out.println(res);
            int temp = Integer.parseInt(s.substring(L,L+2));
            if(temp <=26){
                res += DFS(L+2,s);
            }
            return dy[L] = res;
        }
    }

    public static int solution(String s){
        dy = new int[s.length()+1];
        int answer = DFS(0,s);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("25114"));
        System.out.println(solution("23251232"));
        System.out.println(solution("21020132"));
        System.out.println(solution("21350"));
        System.out.println(solution("120225"));
        System.out.println(solution("232012521"));
    }
}
