package Promgrammers.level2;

import java.util.Stack;

public class 큰수만들기 {

    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        for (char x : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < x - '0') {
                k--;
                stack.pop();
            }
            stack.push(x - '0');
        }
        StringBuilder sb = new StringBuilder();
        for (int x : stack) {
            sb.append(x);
        }
        answer = sb.toString();
        return k == 0 ? answer : answer.substring(0, number.length() - k);
    }
}
