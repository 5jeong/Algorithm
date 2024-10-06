package Algorithm_Study_Inflearn.DFS;

public class 알파코드 {
    static int n, ans;
    static int[] memo;

    static boolean check(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(s) <= 26;
    }

    public static int solution(String s) {
        n = s.length();
        memo = new int[n + 1];
        ans = dfs(0, s);

        return ans;
    }

    private static int dfs(int L, String s) {

        // 값이 있으면 그 값 반환 (메모이제이션)
        if (memo[L] > 0) {
            return memo[L];
        }
        if (L == n) {
            return 1;
        } else {
            for (int i = L; i < n; i++) {
                String temp = s.substring(L, i + 1);
                if (!check(temp)) {
                    break;
                }
                memo[L] += dfs(i + 1, s);
            }
        }
        return memo[L];
    }


    public static void main(String[] args) {
        System.out.println(solution("25114"));
        System.out.println(solution("23251232"));
        System.out.println(solution("21020132"));
        System.out.println(solution("21350"));
        System.out.println(solution("120225"));
        System.out.println(solution("232012521"));
    }
}
