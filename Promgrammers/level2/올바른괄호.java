package Promgrammers.level2;

import java.util.Stack;

public class 올바른괄호 {
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            // 스택이 비어있거나 ch = '('일때 add
            switch (ch){
                case '(' -> stack.push(ch);
                case ')' -> {
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }
//            if (stack.isEmpty() || ch == '(') {
//                stack.add(ch);
//                continue;
//            }
//            // 이전문자가 '('이고, 현재 문자가 ')'이면 pop
//            if (stack.peek() == '(' && ch == ')') {
//                stack.pop();
//            } else {
//                stack.add(ch);
//            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        solution("(())()");
    }
}
