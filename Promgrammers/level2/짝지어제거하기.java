package Promgrammers.level2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack();

        for (char x : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(x);
                continue;
            }
            char temp = stack.peek();
            if (temp == x) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
