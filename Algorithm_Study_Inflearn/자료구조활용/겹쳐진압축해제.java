package Algorithm_Study_Inflearn.자료구조활용;

import java.util.Stack;

public class 겹쳐진압축해제 {
    public static String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == ')') {
                String temp = "";
                while (!stack.peek().equals("(")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                int cnt = 0;
                if (Character.isDigit(stack.peek().charAt(0))) {
                    cnt = Integer.parseInt(stack.pop());
                } else {
                    stack.push(temp);
                    continue;
                }
                String res = "";
                for (int i = 0; i < cnt; i++) {
                    res += temp;
                }
                stack.push(res);
            } else {
                stack.push(String.valueOf(x));
            }
        }
        for (String x : stack) {
            answer += x;
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution("3(a2(b))ef"));
        System.out.println(solution("2(ab)k3(bc)"));
        System.out.println(solution("2(ab3((cd)))"));
        System.out.println(solution("2(2(ab)3(2(ac)))"));
        System.out.println(solution("3(ab2(sg))"));
    }
}
