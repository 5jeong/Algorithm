package softeer.lv2;

import java.util.Scanner;
import java.util.Stack;

public class yeahButHow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == ')' && i != s.length() - 1) {
                stack.push('1');
                stack.push(x);
                stack.push('+');
            } else if (x == ')') {
                stack.push('1');
                stack.push(x);
            } else {
                stack.push(x);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char x : stack) {
            sb.append(x);
        }
        System.out.println(sb);
    }
}
