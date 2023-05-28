package Algorithm_Study_Inflearn.자료구조활용;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 겹쳐진압축해제 {
    public static String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == ')') {
                String temp="";
                while (!stack.isEmpty()) {
                    String c = stack.pop();
                    if(c.equals("(")) {
                        String num = "";
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }
                        String res ="";

                        int cnt=0;
                        if(num.equals("")){
                            cnt=1;
                        }
                        else{
                            cnt = Integer.parseInt(num);
                        }
                        for (int i = 0; i < cnt; i++) {
                            res +=temp;
                        }
                        stack.push(res);
                        break;
                    }
                    temp = c + temp;
                }

            }
            else {
                stack.push(String.valueOf(x));
            }

        }


        for(String x : stack){
            answer+= x;
        }
        return answer;

    }

    public static void main(String[] args){
        System.out.println(solution("3(a2(b))ef"));
        System.out.println(solution("2(ab)k3(bc)"));
        System.out.println(solution("2(ab3((cd)))"));
        System.out.println(solution("2(2(ab)3(2(ac)))"));
        System.out.println(solution("3(ab2(sg))"));
    }
}
