package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IP주소 {
    static Stack<String> stack;
    static int n;
    static List<String> res;

    // 0으로 시작x, (01,012)
    // 0~255 숫자
    private static boolean check(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    // L 부터 s를 탐색하며 가능한 숫자 찾기
    private static void dfs(int L, String s) {
        if (L == n && stack.size() == 4) {
            String ans = "";
            for (String x : stack) {
                ans += x + ".";
            }
            res.add(ans.substring(0, ans.length() - 1));
        } else {
            String temp = "";
            for (int i = L; i < n; i++) {
                temp = s.substring(L, i + 1);
                if (!check(temp)) {
                    break;
                }
                stack.push(temp);
                dfs(i + 1, s);
                stack.pop();
            }
        }
    }

    public static String[] solution(String s) {
        n = s.length();
        stack = new Stack<>();
        res = new ArrayList<>();
        dfs(0, s);
        return res.toArray(String[]::new);
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
