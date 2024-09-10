package Promgrammers.level2;

import java.util.Stack;

public class 괄호회전하기 {
    public static int solution(String s) {
        int len = s.length();
        // 회전
        int ans = 0;
        if (check(s)) {
            ans++;
        }
        for (int i = 1; i < len; i++) {
            s += s.charAt(0);
            s = s.substring(1);
            if (check(s)) {
                ans++;
            }
        }
        return ans;
    }

    // 올바른 괄호 판단
    private static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '[' -> stack.push(']');
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case ']', ')', '}' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != ch) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(check("}]()[{"));
//        System.out.println(check("]()[{}"));
//        System.out.println(check("()[{}]"));
//        System.out.println(check(")[{}]("));
//        System.out.println(check("[{}]()"));
//        System.out.println(check("{}]()["));
        System.out.println(solution("[](){}"));
    }
}
