package Algorithm_Study_Inflearn.자료구조활용;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 겹쳐진압축해제 {
    public static String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == ')') {
                if(stack.size()==s.length()){
                    break;
                }
                String temp = "";
                while (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    if (stack.peek() != '(') {
                        temp += stack.peek();
                    }

                    stack.pop();
                }
                System.out.println("temp : " + temp);
                StringBuffer sb = new StringBuffer(temp);
                String reverse = sb.reverse().toString();


                int a = Character.getNumericValue(stack.pop());
                for (int i = 0; i < a; i++) {
                    for (char b : reverse.toCharArray()) {
                        stack.push(b);
                    }
                }
            } else {
                stack.push(x);
            }

            System.out.print("스택상태 : ");
            for (char ch : stack) {
                System.out.print(ch);
            }
            System.out.println();
        }


        for(char x : stack){
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
