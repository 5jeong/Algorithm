package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class IP주소 {
    static int n;
    static Stack<Integer> stack;
    static ArrayList<String> res;

    static void dfs(int s, String str) {
        if (stack.size() == 4 && s == n) {
            String a = "";
            for (Integer x : stack) {
                a += x + ".";
            }
            res.add(a.substring(0, a.length() - 1));
        } else {
            for (int i = s; i < n; i++) {
                String temp = str.substring(s, i + 1);
                if (check(temp)) {
                    stack.push(Integer.parseInt(temp));
                    dfs(i + 1, str);
                    stack.pop();
                } else {
                    break;
                }
            }

        }
    }

    static boolean check(String str) {
        if (str.charAt(0) == '0' && str.length() >= 2) {
            return false;
        }
        int num = Integer.parseInt(str);
        return num >= 0 && num <= 255;
    }

    public static String[] solution(String s) {
        String[] answer = {};
        n = s.length();
        res = new ArrayList<>();
        stack = new Stack<>();
        dfs(0, s);
        answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2025505")));
        System.out.println(Arrays.toString(solution("0000")));
        System.out.println(Arrays.toString(solution("255003")));
        System.out.println(Arrays.toString(solution("155032012")));
        System.out.println(Arrays.toString(solution("02325123")));
        System.out.println(Arrays.toString(solution("121431211")));
    }
}
