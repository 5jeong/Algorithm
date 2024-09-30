package Algorithm_Study_Inflearn.DFS;

import java.util.*;

class Solution {

    static int n, ans;
    static int[] dy;

    static int dfs(int L, String s) {

        if (dy[L] > 0) {
            return dy[L];
        }

        if (L == n) {
            return 1;
        }

        for (int i = L; i < n; i++) {
            String temp = s.substring(L, i + 1);
            if (check(temp)) {
                dy[L] += dfs(i + 1, s);
            }else{
                break;
            }
        }
        return dy[L];
    }

    // 1 ~ 26숫자인지 확인
    private static boolean check(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }

    public int solution(String s) {
        n = s.length();
        dy = new int[n + 1];
        ans = 0;
        ans = dfs(0, s);

        return ans;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
