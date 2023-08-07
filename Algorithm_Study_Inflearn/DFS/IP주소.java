package Algorithm_Study_Inflearn.DFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class IP주소 {
    static int l;
    static ArrayList<String> res;
    static Stack<String> stack;
    static void DFS(int L,String s){

        if(L==l && stack.size() == 4){
            String str =" ";
            for(String x : stack){
                str+=x+".";
            }
            str = str.substring(0,str.length()-1);
            res.add(str);
        }
        else{
            for(int i =L ; i<s.length();i++){
                if(s.charAt(L) == '0' && i > L) return;
                String temp =  s.substring(L,i+1);
                if(Integer.parseInt(temp) > 255) return;
                stack.push(temp);
                DFS(i+1,s);
                stack.pop();
            }
        }
    }
    public static String[] solution(String s){
        String[] answer ;
        l = s.length();
        res = new ArrayList<>();
        stack = new Stack<>();
        DFS(0,s);
        answer = new String[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("2025505")));
        System.out.println(Arrays.toString(solution("0000")));
        System.out.println(Arrays.toString(solution("255003")));
        System.out.println(Arrays.toString(solution("155032012")));
        System.out.println(Arrays.toString(solution("02325123")));
        System.out.println(Arrays.toString(solution("121431211")));
    }
}
