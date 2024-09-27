package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class IP주소 {
    static Stack<String> stack;
    static int n;
    static ArrayList<String> res;

    private static void dfs(int s, String str) {

        if (stack.size() == 4 && s == n) {
            String temp = "";
            for (String x : stack) {
                temp += x + ".";
            }
            res.add(temp.substring(0, temp.length() - 1));

        } else {
            for (int i = s; i < n; i++) {
                String temp = str.substring(s, i + 1);
                // 유효한 숫자인지 체크
                if (check(temp)) {
                    stack.add(temp);
                    dfs(i + 1, str);
                    stack.pop();
                }
            }
        }
    }

    // 0~255 사이의 숫자
    // 0으로 시작하는 2자리 이상 숫자 x
    private static boolean check(String temp) {
        if (temp.length() > 1 && temp.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(temp);
        return num >= 0 && num <= 255;
    }

    public static String[] solution(String s) {
        String[] answer = {};
        stack = new Stack<>();
        n = s.length();
        res = new ArrayList<>();
        dfs(0, s);
        return res.stream().toArray(String[]::new);
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
