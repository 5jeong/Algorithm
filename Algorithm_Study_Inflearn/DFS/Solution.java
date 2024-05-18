package Algorithm_Study_Inflearn.DFS;

import java.util.*;

class Solution {
    static Stack<String> stack;
    static ArrayList<String> res;

    static void dfs(int L, String s) {
        if (L == s.length() && stack.size() == 4) {
            String a="";
            for(String x : stack){
                a += x+".";
            }
            res.add(a.substring(0,a.length()-1));

        } else {
            for(int i=L;i<s.length();i++){
                String temp = s.substring(L,i+1);
                if(check(temp)){
                    stack.push(temp);
                    dfs(i+1,s);
                    stack.pop();
                }
            }
        }

    }

    static boolean check(String str) {
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(str);
        return num >= 0 && num <= 255;
    }

    public String[] solution(String s) {
        String[] answer = {};
        res = new ArrayList<>();
        stack = new Stack<>();
        dfs(0, s);
        if(res.size()==0){
            return answer;
        }
        answer = new String[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}